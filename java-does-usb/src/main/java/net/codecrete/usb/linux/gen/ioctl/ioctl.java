// Generated by jextract

package net.codecrete.usb.linux.gen.ioctl;

import java.lang.invoke.MethodHandle;

import static java.lang.foreign.ValueLayout.*;
public class ioctl  {

    /* package-private */ ioctl() {}
    public static OfByte C_CHAR = Constants$root.C_CHAR$LAYOUT;
    public static OfShort C_SHORT = Constants$root.C_SHORT$LAYOUT;
    public static OfInt C_INT = Constants$root.C_INT$LAYOUT;
    public static OfLong C_LONG = Constants$root.C_LONG_LONG$LAYOUT;
    public static OfLong C_LONG_LONG = Constants$root.C_LONG_LONG$LAYOUT;
    public static OfFloat C_FLOAT = Constants$root.C_FLOAT$LAYOUT;
    public static OfDouble C_DOUBLE = Constants$root.C_DOUBLE$LAYOUT;
    public static OfAddress C_POINTER = Constants$root.C_POINTER$LAYOUT;
    public static MethodHandle ioctl$MH() {
        return RuntimeHelper.requireNonNull(constants$0.ioctl$MH,"ioctl");
    }
    public static int ioctl ( int __fd,  long __request, Object... x2) {
        var mh$ = ioctl$MH();
        try {
            return (int)mh$.invokeExact(__fd, __request, x2);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }
}


