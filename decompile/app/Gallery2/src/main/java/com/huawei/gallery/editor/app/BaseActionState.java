package com.huawei.gallery.editor.app;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.ViewGroup;
import com.android.gallery3d.R;
import com.android.gallery3d.ui.GLRoot;
import com.android.gallery3d.util.GalleryLog;
import com.android.gallery3d.util.GalleryUtils;
import com.android.gallery3d.util.ReportToBigData;
import com.huawei.gallery.actionbar.Action;
import com.huawei.gallery.editor.tools.SaveImage;
import com.huawei.gallery.editor.ui.BaseEditorView;

public abstract class BaseActionState extends EditorState {
    private static final /* synthetic */ int[] -com-huawei-gallery-actionbar-ActionSwitchesValues = null;

    private static /* synthetic */ int[] -getcom-huawei-gallery-actionbar-ActionSwitchesValues() {
        if (-com-huawei-gallery-actionbar-ActionSwitchesValues != null) {
            return -com-huawei-gallery-actionbar-ActionSwitchesValues;
        }
        int[] iArr = new int[Action.values().length];
        try {
            iArr[Action.ADD.ordinal()] = 5;
        } catch (NoSuchFieldError e) {
        }
        try {
            iArr[Action.ADD_ALBUM.ordinal()] = 6;
        } catch (NoSuchFieldError e2) {
        }
        try {
            iArr[Action.ADD_COMMENT.ordinal()] = 7;
        } catch (NoSuchFieldError e3) {
        }
        try {
            iArr[Action.AIRSHARE.ordinal()] = 8;
        } catch (NoSuchFieldError e4) {
        }
        try {
            iArr[Action.ALBUM.ordinal()] = 9;
        } catch (NoSuchFieldError e5) {
        }
        try {
            iArr[Action.ALL.ordinal()] = 10;
        } catch (NoSuchFieldError e6) {
        }
        try {
            iArr[Action.BACK.ordinal()] = 11;
        } catch (NoSuchFieldError e7) {
        }
        try {
            iArr[Action.CANCEL_DETAIL.ordinal()] = 12;
        } catch (NoSuchFieldError e8) {
        }
        try {
            iArr[Action.COLLAGE.ordinal()] = 13;
        } catch (NoSuchFieldError e9) {
        }
        try {
            iArr[Action.COMMENT.ordinal()] = 14;
        } catch (NoSuchFieldError e10) {
        }
        try {
            iArr[Action.COPY.ordinal()] = 15;
        } catch (NoSuchFieldError e11) {
        }
        try {
            iArr[Action.DEALL.ordinal()] = 16;
        } catch (NoSuchFieldError e12) {
        }
        try {
            iArr[Action.DEL.ordinal()] = 17;
        } catch (NoSuchFieldError e13) {
        }
        try {
            iArr[Action.DETAIL.ordinal()] = 18;
        } catch (NoSuchFieldError e14) {
        }
        try {
            iArr[Action.DYNAMIC_ALBUM.ordinal()] = 19;
        } catch (NoSuchFieldError e15) {
        }
        try {
            iArr[Action.EDIT.ordinal()] = 20;
        } catch (NoSuchFieldError e16) {
        }
        try {
            iArr[Action.EDIT_COMMENT.ordinal()] = 21;
        } catch (NoSuchFieldError e17) {
        }
        try {
            iArr[Action.GOTO_GALLERY.ordinal()] = 22;
        } catch (NoSuchFieldError e18) {
        }
        try {
            iArr[Action.HIDE.ordinal()] = 23;
        } catch (NoSuchFieldError e19) {
        }
        try {
            iArr[Action.INFO.ordinal()] = 24;
        } catch (NoSuchFieldError e20) {
        }
        try {
            iArr[Action.KEYGUARD_LIKE.ordinal()] = 25;
        } catch (NoSuchFieldError e21) {
        }
        try {
            iArr[Action.KEYGUARD_NOT_LIKE.ordinal()] = 26;
        } catch (NoSuchFieldError e22) {
        }
        try {
            iArr[Action.LOOPPLAY.ordinal()] = 27;
        } catch (NoSuchFieldError e23) {
        }
        try {
            iArr[Action.MAP.ordinal()] = 28;
        } catch (NoSuchFieldError e24) {
        }
        try {
            iArr[Action.MENU.ordinal()] = 29;
        } catch (NoSuchFieldError e25) {
        }
        try {
            iArr[Action.MORE_EDIT.ordinal()] = 30;
        } catch (NoSuchFieldError e26) {
        }
        try {
            iArr[Action.MOVE.ordinal()] = 31;
        } catch (NoSuchFieldError e27) {
        }
        try {
            iArr[Action.MOVEIN.ordinal()] = 32;
        } catch (NoSuchFieldError e28) {
        }
        try {
            iArr[Action.MOVEOUT.ordinal()] = 33;
        } catch (NoSuchFieldError e29) {
        }
        try {
            iArr[Action.MULTISCREEN.ordinal()] = 34;
        } catch (NoSuchFieldError e30) {
        }
        try {
            iArr[Action.MULTISCREEN_ACTIVITED.ordinal()] = 35;
        } catch (NoSuchFieldError e31) {
        }
        try {
            iArr[Action.MULTI_SELECTION.ordinal()] = 36;
        } catch (NoSuchFieldError e32) {
        }
        try {
            iArr[Action.MULTI_SELECTION_ON.ordinal()] = 37;
        } catch (NoSuchFieldError e33) {
        }
        try {
            iArr[Action.MYFAVORITE.ordinal()] = 38;
        } catch (NoSuchFieldError e34) {
        }
        try {
            iArr[Action.NO.ordinal()] = 39;
        } catch (NoSuchFieldError e35) {
        }
        try {
            iArr[Action.NONE.ordinal()] = 40;
        } catch (NoSuchFieldError e36) {
        }
        try {
            iArr[Action.NOT_MYFAVORITE.ordinal()] = 41;
        } catch (NoSuchFieldError e37) {
        }
        try {
            iArr[Action.OK.ordinal()] = 1;
        } catch (NoSuchFieldError e38) {
        }
        try {
            iArr[Action.PHOTOSHARE_ACCOUNT.ordinal()] = 42;
        } catch (NoSuchFieldError e39) {
        }
        try {
            iArr[Action.PHOTOSHARE_ADDPICTURE.ordinal()] = 43;
        } catch (NoSuchFieldError e40) {
        }
        try {
            iArr[Action.PHOTOSHARE_BACKUP.ordinal()] = 44;
        } catch (NoSuchFieldError e41) {
        }
        try {
            iArr[Action.PHOTOSHARE_CANCEL_RECEIVE.ordinal()] = 45;
        } catch (NoSuchFieldError e42) {
        }
        try {
            iArr[Action.PHOTOSHARE_CLEAR.ordinal()] = 46;
        } catch (NoSuchFieldError e43) {
        }
        try {
            iArr[Action.PHOTOSHARE_COMBINE.ordinal()] = 47;
        } catch (NoSuchFieldError e44) {
        }
        try {
            iArr[Action.PHOTOSHARE_CONTACT.ordinal()] = 48;
        } catch (NoSuchFieldError e45) {
        }
        try {
            iArr[Action.PHOTOSHARE_CREATE_NEW_PEOPLE_TAG.ordinal()] = 49;
        } catch (NoSuchFieldError e46) {
        }
        try {
            iArr[Action.PHOTOSHARE_CREATE_NEW_SHARE.ordinal()] = 50;
        } catch (NoSuchFieldError e47) {
        }
        try {
            iArr[Action.PHOTOSHARE_DELETE.ordinal()] = 51;
        } catch (NoSuchFieldError e48) {
        }
        try {
            iArr[Action.PHOTOSHARE_DOWNLOAD.ordinal()] = 52;
        } catch (NoSuchFieldError e49) {
        }
        try {
            iArr[Action.PHOTOSHARE_DOWNLOADING.ordinal()] = 53;
        } catch (NoSuchFieldError e50) {
        }
        try {
            iArr[Action.PHOTOSHARE_DOWNLOAD_START.ordinal()] = 54;
        } catch (NoSuchFieldError e51) {
        }
        try {
            iArr[Action.PHOTOSHARE_EDITSHARE.ordinal()] = 55;
        } catch (NoSuchFieldError e52) {
        }
        try {
            iArr[Action.PHOTOSHARE_EMAIL.ordinal()] = 56;
        } catch (NoSuchFieldError e53) {
        }
        try {
            iArr[Action.PHOTOSHARE_LINK.ordinal()] = 57;
        } catch (NoSuchFieldError e54) {
        }
        try {
            iArr[Action.PHOTOSHARE_MANAGE_DOWNLOAD.ordinal()] = 58;
        } catch (NoSuchFieldError e55) {
        }
        try {
            iArr[Action.PHOTOSHARE_MANAGE_UPLOAD.ordinal()] = 59;
        } catch (NoSuchFieldError e56) {
        }
        try {
            iArr[Action.PHOTOSHARE_MESSAGE.ordinal()] = 60;
        } catch (NoSuchFieldError e57) {
        }
        try {
            iArr[Action.PHOTOSHARE_MOVE.ordinal()] = 61;
        } catch (NoSuchFieldError e58) {
        }
        try {
            iArr[Action.PHOTOSHARE_MULTI_DOWNLOAD.ordinal()] = 62;
        } catch (NoSuchFieldError e59) {
        }
        try {
            iArr[Action.PHOTOSHARE_NOT_THIS_PERSON.ordinal()] = 63;
        } catch (NoSuchFieldError e60) {
        }
        try {
            iArr[Action.PHOTOSHARE_PAUSE.ordinal()] = 64;
        } catch (NoSuchFieldError e61) {
        }
        try {
            iArr[Action.PHOTOSHARE_REMOVE_PEOPLE_TAG.ordinal()] = 65;
        } catch (NoSuchFieldError e62) {
        }
        try {
            iArr[Action.PHOTOSHARE_RENAME.ordinal()] = 66;
        } catch (NoSuchFieldError e63) {
        }
        try {
            iArr[Action.PHOTOSHARE_SETTINGS.ordinal()] = 67;
        } catch (NoSuchFieldError e64) {
        }
        try {
            iArr[Action.PHOTOSHARE_UPLOAD_START.ordinal()] = 68;
        } catch (NoSuchFieldError e65) {
        }
        try {
            iArr[Action.PRINT.ordinal()] = 69;
        } catch (NoSuchFieldError e66) {
        }
        try {
            iArr[Action.RANGE_MEASURE.ordinal()] = 70;
        } catch (NoSuchFieldError e67) {
        }
        try {
            iArr[Action.RECYCLE_CLEAN_BIN.ordinal()] = 71;
        } catch (NoSuchFieldError e68) {
        }
        try {
            iArr[Action.RECYCLE_DELETE.ordinal()] = 72;
        } catch (NoSuchFieldError e69) {
        }
        try {
            iArr[Action.RECYCLE_RECOVERY.ordinal()] = 73;
        } catch (NoSuchFieldError e70) {
        }
        try {
            iArr[Action.REDO.ordinal()] = 2;
        } catch (NoSuchFieldError e71) {
        }
        try {
            iArr[Action.REMOVE.ordinal()] = 74;
        } catch (NoSuchFieldError e72) {
        }
        try {
            iArr[Action.RENAME.ordinal()] = 75;
        } catch (NoSuchFieldError e73) {
        }
        try {
            iArr[Action.RE_SEARCH.ordinal()] = 76;
        } catch (NoSuchFieldError e74) {
        }
        try {
            iArr[Action.ROTATE_LEFT.ordinal()] = 77;
        } catch (NoSuchFieldError e75) {
        }
        try {
            iArr[Action.ROTATE_RIGHT.ordinal()] = 78;
        } catch (NoSuchFieldError e76) {
        }
        try {
            iArr[Action.SAVE.ordinal()] = 3;
        } catch (NoSuchFieldError e77) {
        }
        try {
            iArr[Action.SAVE_BURST.ordinal()] = 79;
        } catch (NoSuchFieldError e78) {
        }
        try {
            iArr[Action.SEE_BARCODE_INFO.ordinal()] = 80;
        } catch (NoSuchFieldError e79) {
        }
        try {
            iArr[Action.SETAS.ordinal()] = 81;
        } catch (NoSuchFieldError e80) {
        }
        try {
            iArr[Action.SETAS_BOTH.ordinal()] = 82;
        } catch (NoSuchFieldError e81) {
        }
        try {
            iArr[Action.SETAS_FIXED.ordinal()] = 83;
        } catch (NoSuchFieldError e82) {
        }
        try {
            iArr[Action.SETAS_FIXED_ACTIVED.ordinal()] = 84;
        } catch (NoSuchFieldError e83) {
        }
        try {
            iArr[Action.SETAS_HOME.ordinal()] = 85;
        } catch (NoSuchFieldError e84) {
        }
        try {
            iArr[Action.SETAS_SCROLLABLE.ordinal()] = 86;
        } catch (NoSuchFieldError e85) {
        }
        try {
            iArr[Action.SETAS_SCROLLABLE_ACTIVED.ordinal()] = 87;
        } catch (NoSuchFieldError e86) {
        }
        try {
            iArr[Action.SETAS_UNLOCK.ordinal()] = 88;
        } catch (NoSuchFieldError e87) {
        }
        try {
            iArr[Action.SETTINGS.ordinal()] = 89;
        } catch (NoSuchFieldError e88) {
        }
        try {
            iArr[Action.SHARE.ordinal()] = 90;
        } catch (NoSuchFieldError e89) {
        }
        try {
            iArr[Action.SHOW_ON_MAP.ordinal()] = 91;
        } catch (NoSuchFieldError e90) {
        }
        try {
            iArr[Action.SINGLE_SELECTION.ordinal()] = 92;
        } catch (NoSuchFieldError e91) {
        }
        try {
            iArr[Action.SINGLE_SELECTION_ON.ordinal()] = 93;
        } catch (NoSuchFieldError e92) {
        }
        try {
            iArr[Action.SLIDESHOW.ordinal()] = 94;
        } catch (NoSuchFieldError e93) {
        }
        try {
            iArr[Action.STORY_ALBUM_REMOVE.ordinal()] = 95;
        } catch (NoSuchFieldError e94) {
        }
        try {
            iArr[Action.STORY_ITEM_REMOVE.ordinal()] = 96;
        } catch (NoSuchFieldError e95) {
        }
        try {
            iArr[Action.STORY_RENAME.ordinal()] = 97;
        } catch (NoSuchFieldError e96) {
        }
        try {
            iArr[Action.TIME.ordinal()] = 98;
        } catch (NoSuchFieldError e97) {
        }
        try {
            iArr[Action.TOGIF.ordinal()] = 99;
        } catch (NoSuchFieldError e98) {
        }
        try {
            iArr[Action.UNDO.ordinal()] = 4;
        } catch (NoSuchFieldError e99) {
        }
        try {
            iArr[Action.WITHOUT_UPDATE.ordinal()] = 100;
        } catch (NoSuchFieldError e100) {
        }
        try {
            iArr[Action.WITH_UPDATE.ordinal()] = 101;
        } catch (NoSuchFieldError e101) {
        }
        -com-huawei-gallery-actionbar-ActionSwitchesValues = iArr;
        return iArr;
    }

    public BaseActionState(Context context, ViewGroup layout, BaseEditorView editorView) {
        super(context, layout, editorView);
    }

    public boolean onBackPressed() {
        this.mEditorView.setExitMode(0);
        if (getImage().hasModifications()) {
            showSaveTips();
        } else {
            this.mEditorView.leaveEditor();
        }
        return true;
    }

    public void onActionItemClick(Action action) {
        switch (-getcom-huawei-gallery-actionbar-ActionSwitchesValues()[action.ordinal()]) {
            case 1:
                ReportToBigData.report(110);
                return;
            case 2:
                this.mEditorView.getEditorManager().redo();
                ReportToBigData.report(112);
                return;
            case 3:
                if (getImage().hasModifications()) {
                    saveImage();
                    return;
                } else {
                    this.mEditorView.leaveEditor(getImage().getUri(), true);
                    return;
                }
            case 4:
                this.mEditorView.getEditorManager().undo();
                ReportToBigData.report(111);
                return;
            default:
                return;
        }
    }

    private void showSaveTips() {
        Builder builder = new Builder(this.mEditorView.getContext());
        builder.setTitle(R.string.photoeditor_unsave_Confirm_Msg);
        builder.setPositiveButton(R.string.gallery_yes, new OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                BaseActionState.this.saveImage();
                ReportToBigData.report(133, String.format("{SaveTips:%s}", new Object[]{"Save"}));
            }
        });
        builder.setNegativeButton(R.string.gallery_no, new OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                GLRoot root = BaseActionState.this.mEditorView.getGLRoot();
                if (root != null) {
                    root.lockRenderThread();
                    try {
                        BaseActionState.this.mEditorView.leaveEditor();
                        ReportToBigData.report(133, String.format("{SaveTips:%s}", new Object[]{"Discard"}));
                    } finally {
                        root.unlockRenderThread();
                    }
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        GalleryUtils.setTextColor(alertDialog.getButton(-2), this.mEditorView.getContext().getResources());
    }

    private void saveImage() {
        if (this.mEditorView.isSavingImage()) {
            GalleryLog.w("BaseActionState", "Saving is doing, ignore this");
            return;
        }
        SaveImage.saveImage(getImage().getPreset(), this.mEditorView.getEditorManager());
        this.mEditorView.showSavingProgress(needShowSavingProgress());
    }

    protected boolean needShowSavingProgress() {
        return true;
    }
}
