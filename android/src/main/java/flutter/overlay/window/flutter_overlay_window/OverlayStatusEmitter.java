package flutter.overlay.window.flutter_overlay_window;

public abstract class OverlayStatusEmitter {
    static private final String methodName_isShowingOverlay = "isShowingOverlay";
    static private final String methodName_screenChange = "onScreenChange";
    static private boolean lastEmittedStatus;
    
    static void emitIsShowing(boolean isShowing) {
        if(isShowing == lastEmittedStatus) return;
        lastEmittedStatus = isShowing;
        if(CachedMessageChannels.mainAppMessageChannel != null) {
            CachedMessageChannels.mainAppMessageChannel.invokeMethod(methodName_isShowingOverlay, isShowing);
        }
        if(CachedMessageChannels.overlayMessageChannel != null) {
            CachedMessageChannels.overlayMessageChannel.invokeMethod(methodName_isShowingOverlay, isShowing);
        }
    }

    static void emitScreenChange() {
        if(CachedMessageChannels.mainAppMessageChannel != null) {
            CachedMessageChannels.mainAppMessageChannel.invokeMethod(methodName_screenChange, null);
        }
        if(CachedMessageChannels.overlayMessageChannel != null) {
            CachedMessageChannels.overlayMessageChannel.invokeMethod(methodName_screenChange, null);
        }
    }
}
