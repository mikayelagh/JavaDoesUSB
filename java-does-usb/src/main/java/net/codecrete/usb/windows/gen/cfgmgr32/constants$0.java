// Generated by jextract

package net.codecrete.usb.windows.gen.cfgmgr32;

import java.lang.foreign.FunctionDescriptor;
import java.lang.invoke.MethodHandle;
class constants$0 {

    static final FunctionDescriptor CM_Get_Device_IDW$FUNC = FunctionDescriptor.of(Constants$root.C_LONG$LAYOUT,
        Constants$root.C_LONG$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_LONG$LAYOUT,
        Constants$root.C_LONG$LAYOUT
    );
    static final MethodHandle CM_Get_Device_IDW$MH = RuntimeHelper.downcallHandle(
        "CM_Get_Device_IDW",
        constants$0.CM_Get_Device_IDW$FUNC
    );
    static final FunctionDescriptor CM_Get_Parent$FUNC = FunctionDescriptor.of(Constants$root.C_LONG$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_LONG$LAYOUT,
        Constants$root.C_LONG$LAYOUT
    );
    static final MethodHandle CM_Get_Parent$MH = RuntimeHelper.downcallHandle(
        "CM_Get_Parent",
        constants$0.CM_Get_Parent$FUNC
    );
}


