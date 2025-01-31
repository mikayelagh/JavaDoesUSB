//
// Java Does USB
// Copyright (c) 2022 Manuel Bleichenbacher
// Licensed under MIT License
// https://opensource.org/licenses/MIT
//

package net.codecrete.usb;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * USB device.
 * <p>
 * In order to make control requests and transfer data, the device must be
 * opened and an interface must be claimed. In the open state, this current
 * process has exclusive access to the device.
 * </p>
 * <p>
 * Information about the device can be queried in both the open and the
 * closed state.
 * </p>
 */
public interface USBDevice {

    /**
     * USB product ID.
     *
     * @return product ID
     */
    int productId();

    /**
     * USB vendor ID.
     *
     * @return vendor ID
     */
    int vendorId();

    /**
     * Product name.
     *
     * @return product name or {@code null} if not provided by the device
     */
    String product();

    /**
     * Manufacturer name
     *
     * @return manufacturer name or {@code null} if not provided by the device
     */
    String manufacturer();

    /**
     * Serial number
     * <p>
     * Even though this is supposed to be a human-readable string,
     * some devices are known to provide binary data.
     * </p>
     *
     * @return serial number or {@code null} if not provided by the device
     */
    String serialNumber();

    /**
     * USB device class code ({@code bDeviceClass} from device descriptor).
     *
     * @return class code
     */
    int classCode();

    /**
     * USB device subclass code ({@code bDeviceSubClass} from device descriptor).
     *
     * @return subclass code
     */
    int subclassCode();

    /**
     * USB device protocol ({@code bDeviceProtocol} from device descriptor).
     *
     * @return protocol code
     */
    int protocolCode();

    /**
     * USB protocol version supported by this device.
     *
     * @return version
     */
    Version usbVersion();

    /**
     * Device version (as declared by the manufacturer).
     *
     * @return version
     */
    Version deviceVersion();

    /**
     * Opens the device for communication.
     */
    void open();

    /**
     * Indicates if the device is open.
     *
     * @return {@code true} if the device is open, {@code false} if it is closed.
     */
    boolean isOpen();

    /**
     * Closes the device.
     */
    void close();

    /**
     * Gets the interfaces of this device.
     *
     * @return a list of USB interfaces
     */
    List<USBInterface> interfaces();

    /**
     * Gets the interface with the specified number.
     * @param interfaceNumber the interface number
     * @return the interface, or {@code null} if no interface with the given number exists
     */
    USBInterface getInterface(int interfaceNumber);

    /**
     * Claims the specified interface for exclusive use.
     *
     * @param interfaceNumber the interface number
     */
    void claimInterface(int interfaceNumber);

    /**
     * Selects the alternate settings for the specified interface.
     * <p>
     * The device must be open and the interface must be claimed for exclusive access.
     * </p>
     * @param interfaceNumber interface number
     * @param alternateNumber alternate setting number
     */
    void selectAlternateSetting(int interfaceNumber, int alternateNumber);

    /**
     * Releases the specified interface from exclusive use.
     *
     * @param interfaceNumber the interface number
     */
    void releaseInterface(int interfaceNumber);

    /**
     * Requests data from the control endpoint.
     * <p>
     * This method blocks until the device has responded or an error has occurred.
     * </p>
     * <p>
     * The control transfer request is sent to endpoint 0. The transfer is expected to
     * have a Data In stage.
     * </p>
     * <p>
     * Requests with an interface or an endpoint as recipient are expected to
     * have the interface and endpoint number, respectively, in the lower byte of
     * {@code wIndex}. This convention is enforced by Windows. The addressed interface
     * or the interface of the addressed endpoint must have been claimed.
     * </p>
     *
     * @param setup  control transfer setup parameters
     * @param length maximum length of expected data
     * @return received data.
     */
    byte[] controlTransferIn(USBControlTransfer setup, int length);

    /**
     * Executes a control transfer request and optionally sends data.
     * <p>
     * This method blocks until the device has acknowledge the request or an error has occurred.
     * </p>
     * <p>
     * The control transfer request is sent to endpoint 0. The transfer is expected to either have
     * no data stage or a Data Out stage.
     * </p>
     * <p>
     * Requests with an interface or an endpoint as recipient are expected to
     * have the interface and endpoint number, respectively, in the lower byte of
     * {@code wIndex}. This convention is enforced by Windows. The addressed interface
     * or the interface of the addressed endpoint must have been claimed.
     * </p>
     *
     * @param setup control transfer setup parameters
     * @param data  data to send, or {@code null} if the transfer has no data stage.
     */
    void controlTransferOut(USBControlTransfer setup, byte[] data);

    /**
     * Sends data to this device.
     * <p>
     * This method blocks until the data has been sent or an error has occurred.
     * </p>
     * <p>
     * This method can send data to bulk and interrupt endpoints.
     * </p>
     *
     * @param endpointNumber endpoint number (in the range between 1 and 127)
     * @param data           data to send
     */
    void transferOut(int endpointNumber, byte[] data);

    /**
     * Sends data to this device.
     * <p>
     * This method blocks until the data has been sent, the timeout period has expired
     * or an error has occurred. If the timeout expires, a {@link USBTimeoutException} is thrown.
     * </p>
     * <p>
     * This method can send data to bulk and interrupt endpoints.
     * </p>
     *
     * @param endpointNumber the endpoint number (in the range between 1 and 127)
     * @param timeout        the timeout period, in milliseconds (0 for no timeout)
     * @param data           data to send
     */
    void transferOut(int endpointNumber, byte[] data, int timeout);

    /**
     * Receives data from this device.
     * <p>
     * This method blocks until at least a packet has been received or an error has occurred.
     * </p>
     * <p>
     * The returned data is the payload of a packet. It can have a length of 0 if the USB device
     * sends zero-length packets to indicate the end of a data unit.
     * </p>
     * <p>
     * This method can receive data from bulk and interrupt endpoints.
     * </p>
     *
     * @param endpointNumber endpoint number (in the range between 1 and 127, i.e. without the direction bit)
     * @return received data
     */
    byte[] transferIn(int endpointNumber);

    /**
     * Receives data from this device.
     * <p>
     * This method blocks until at least a packet has been received, the timeout period has expired
     * or an error has occurred. If the timeout expired, a {@link USBTimeoutException} is thrown.
     * </p>
     * <p>
     * The returned data is the payload of a packet. It can have a length of 0 if the USB device
     * sends zero-length packets to indicate the end of a data unit.
     * </p>
     * <p>
     * This method can receive data from bulk and interrupt endpoints.
     * </p>
     *
     * @param endpointNumber the endpoint number (in the range between 1 and 127, i.e. without the direction bit)
     * @param timeout        the timeout period, in milliseconds (0 for no timeout)
     * @return received data
     */
    byte[] transferIn(int endpointNumber, int timeout);

    /**
     * Opens a new output stream to send data to a bulk endpoint.
     * <p>
     * All data written to this output stream is sent to the specified bulk endpoint.
     * If {@link #transferOut(int, byte[])} and a output stream or multiple output streams
     * are used concurrently for the same endpoint, the behavior is unpredictable.
     * </p>
     *
     * @param endpointNumber bulk endpoint number (in the range between 1 and 127)
     * @return the new output stream
     */
    OutputStream openOutputStream(int endpointNumber);

    /**
     * Opens a new input stream to receive data from a bulk endpoint.
     * <p>
     * All data received from the specified bulk endpoint can be read using this input stream.
     * </p>
     * <p>
     * If {@link #transferIn(int)} and an input stream or multiple input streams
     * are used concurrently for the same endpoint, the behavior is unpredictable.
     * </p>
     * @param endpointNumber bulk endpoint number (in the range between 1 and 127, i.e. without the direction bit)
     * @return the new input stream
     */
    InputStream openInputStream(int endpointNumber);

    /**
     * Clears an endpoint's halt condition.
     * <p>
     * An endpoint is halted (aka stalled) if an error occurs in the communication. Before the
     * communication can resume, the halt condition must be cleared. A halt condition can exist
     * in a single direction only.
     * </p>
     * <p>
     * Control endpoint 0 will never be halted.
     * </p>
     * @param direction endpoint direction
     * @param endpointNumber endpoint number (in the range between 1 and 127)
     */
    void clearHalt(USBDirection direction, int endpointNumber);

    /**
     * Gets the configuration descriptor.
     *
     * @return the configuration descriptor (as a byte array)
     */
    byte[] configurationDescriptor();
}
