// Generated by jextract

package net.codecrete.usb.windows.gen.setupapi;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;
public class _SP_DEVINFO_DATA {

    static final  GroupLayout $struct$LAYOUT = MemoryLayout.structLayout(
        Constants$root.C_LONG$LAYOUT.withName("cbSize"),
        MemoryLayout.structLayout(
            Constants$root.C_LONG$LAYOUT.withName("Data1"),
            Constants$root.C_SHORT$LAYOUT.withName("Data2"),
            Constants$root.C_SHORT$LAYOUT.withName("Data3"),
            MemoryLayout.sequenceLayout(8, Constants$root.C_CHAR$LAYOUT).withName("Data4")
        ).withName("ClassGuid"),
        Constants$root.C_LONG$LAYOUT.withName("DevInst"),
        Constants$root.C_LONG_LONG$LAYOUT.withName("Reserved")
    ).withName("_SP_DEVINFO_DATA");
    public static MemoryLayout $LAYOUT() {
        return _SP_DEVINFO_DATA.$struct$LAYOUT;
    }
    static final VarHandle cbSize$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("cbSize"));
    public static VarHandle cbSize$VH() {
        return _SP_DEVINFO_DATA.cbSize$VH;
    }
    public static int cbSize$get(MemorySegment seg) {
        return (int)_SP_DEVINFO_DATA.cbSize$VH.get(seg);
    }
    public static void cbSize$set( MemorySegment seg, int x) {
        _SP_DEVINFO_DATA.cbSize$VH.set(seg, x);
    }
    public static int cbSize$get(MemorySegment seg, long index) {
        return (int)_SP_DEVINFO_DATA.cbSize$VH.get(seg.asSlice(index*sizeof()));
    }
    public static void cbSize$set(MemorySegment seg, long index, int x) {
        _SP_DEVINFO_DATA.cbSize$VH.set(seg.asSlice(index*sizeof()), x);
    }
    public static MemorySegment ClassGuid$slice(MemorySegment seg) {
        return seg.asSlice(4, 16);
    }
    static final VarHandle DevInst$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("DevInst"));
    public static VarHandle DevInst$VH() {
        return _SP_DEVINFO_DATA.DevInst$VH;
    }
    public static int DevInst$get(MemorySegment seg) {
        return (int)_SP_DEVINFO_DATA.DevInst$VH.get(seg);
    }
    public static void DevInst$set( MemorySegment seg, int x) {
        _SP_DEVINFO_DATA.DevInst$VH.set(seg, x);
    }
    public static int DevInst$get(MemorySegment seg, long index) {
        return (int)_SP_DEVINFO_DATA.DevInst$VH.get(seg.asSlice(index*sizeof()));
    }
    public static void DevInst$set(MemorySegment seg, long index, int x) {
        _SP_DEVINFO_DATA.DevInst$VH.set(seg.asSlice(index*sizeof()), x);
    }
    static final VarHandle Reserved$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("Reserved"));
    public static VarHandle Reserved$VH() {
        return _SP_DEVINFO_DATA.Reserved$VH;
    }
    public static long Reserved$get(MemorySegment seg) {
        return (long)_SP_DEVINFO_DATA.Reserved$VH.get(seg);
    }
    public static void Reserved$set( MemorySegment seg, long x) {
        _SP_DEVINFO_DATA.Reserved$VH.set(seg, x);
    }
    public static long Reserved$get(MemorySegment seg, long index) {
        return (long)_SP_DEVINFO_DATA.Reserved$VH.get(seg.asSlice(index*sizeof()));
    }
    public static void Reserved$set(MemorySegment seg, long index, long x) {
        _SP_DEVINFO_DATA.Reserved$VH.set(seg.asSlice(index*sizeof()), x);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocateArray(int len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment ofAddress(MemoryAddress addr, MemorySession session) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, session); }
}


