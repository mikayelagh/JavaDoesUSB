//
// Java Does USB
// Copyright (c) 2022 Manuel Bleichenbacher
// Licensed under MIT License
// https://opensource.org/licenses/MIT
//
// Reference C++ code for macOS
//

#pragma once

#include "usb_device.hpp"

#include <condition_variable>
#include <functional>
#include <memory>
#include <mutex>
#include <thread>
#include <vector>

struct udev;
struct udev_device;


/**
 * Registry of connected USB devices.
 */
class usb_registry {
public:
    /// Create a new instance
    usb_registry();
    ~usb_registry();
    
    /// Sets a function to be called when a new device is connected.
    void set_on_device_connected(std::function<void(usb_device_ptr device)> callback);
    /// Sets a function to be called when a device is disconnected
    void set_on_device_disconnected(std::function<void(usb_device_ptr device)> callback);

    /// Starts the registry
    void start();
    
    /// Gets the currently connected devices.
    std::vector<std::shared_ptr<usb_device>> get_devices();

private:
    /// Method run in background to monitor USB devices
    void monitor();
    void enumerate_present_devices(udev* udev);
    
    void on_device_connected(udev_device* udev_dev);
    void on_device_disconnected(udev_device* udev_dev);

    std::shared_ptr<usb_device> create_device(udev_device* udev_dev);

    std::vector<usb_device_ptr> devices;

    std::function<void(usb_device_ptr device)> on_connected_callback;
    std::function<void(usb_device_ptr device)> on_disconnected_callback;

    std::thread monitor_thread;

    int wake_event_fd;

    bool is_device_list_ready;
    std::mutex monitor_mutex;
    std::condition_variable monitor_condition;
};
