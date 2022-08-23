// Generated by jextract

package net.codecrete.usb.windows.gen.cfgmgr32;

import java.lang.foreign.Addressable;
import java.lang.invoke.MethodHandle;

import static java.lang.foreign.ValueLayout.*;
public class CfgMgr32  {

    /* package-private */ CfgMgr32() {}
    public static OfByte C_CHAR = Constants$root.C_CHAR$LAYOUT;
    public static OfShort C_SHORT = Constants$root.C_SHORT$LAYOUT;
    public static OfInt C_INT = Constants$root.C_LONG$LAYOUT;
    public static OfInt C_LONG = Constants$root.C_LONG$LAYOUT;
    public static OfLong C_LONG_LONG = Constants$root.C_LONG_LONG$LAYOUT;
    public static OfFloat C_FLOAT = Constants$root.C_FLOAT$LAYOUT;
    public static OfDouble C_DOUBLE = Constants$root.C_DOUBLE$LAYOUT;
    public static OfAddress C_POINTER = Constants$root.C_POINTER$LAYOUT;
    public static MethodHandle CM_Get_Device_IDW$MH() {
        return RuntimeHelper.requireNonNull(constants$0.CM_Get_Device_IDW$MH,"CM_Get_Device_IDW");
    }
    public static int CM_Get_Device_IDW ( int dnDevInst,  Addressable Buffer,  int BufferLen,  int ulFlags) {
        var mh$ = CM_Get_Device_IDW$MH();
        try {
            return (int)mh$.invokeExact(dnDevInst, Buffer, BufferLen, ulFlags);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }
    public static MethodHandle CM_Get_Parent$MH() {
        return RuntimeHelper.requireNonNull(constants$0.CM_Get_Parent$MH,"CM_Get_Parent");
    }
    public static int CM_Get_Parent ( Addressable pdnDevInst,  int dnDevInst,  int ulFlags) {
        var mh$ = CM_Get_Parent$MH();
        try {
            return (int)mh$.invokeExact(pdnDevInst, dnDevInst, ulFlags);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }
}


