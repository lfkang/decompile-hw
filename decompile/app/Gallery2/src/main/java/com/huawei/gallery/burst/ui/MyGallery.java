package com.huawei.gallery.burst.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Transformation;
import com.android.gallery3d.R;
import com.android.gallery3d.R$styleable;
import com.huawei.gallery.animation.CubicBezierInterpolator;
import com.huawei.gallery.app.AbsAlbumPage;
import com.huawei.watermark.manager.parse.WMElement;

public class MyGallery extends MyAbsSpinner implements OnGestureListener {
    private int mAnimationDuration;
    private Runnable mDisableSuppressSelectionChangedRunnable;
    private int mDownTouchPosition;
    private View mDownTouchView;
    private FlingRunnable mFlingRunnable;
    private GestureDetector mGestureDetector;
    private int mGravity;
    private boolean mIsFirstScroll;
    private boolean mIsRtl;
    private int mLeftMost;
    private boolean mReceivedInvokeKeyDown;
    private int mRightMost;
    private int mSelectedCenterOffset;
    private View mSelectedChild;
    private boolean mShouldCallbackDuringFling;
    private boolean mShouldCallbackOnUnselectedItemClick;
    private boolean mShouldStopFling;
    private int mSingleContentWidth;
    private int mSpacing;
    private boolean mSuppressSelectionChanged;
    private float mUnselectedAlpha;

    private class FlingRunnable implements Runnable {
        private int mLastFlingX;
        private MyScroller mScroller;

        public FlingRunnable() {
            this.mScroller = new MyScroller(MyGallery.this.getContext(), new CubicBezierInterpolator(0.51f, 0.35f, 0.15f, WMElement.CAMERASIZEVALUE1B1));
        }

        private void startCommon() {
            MyGallery.this.removeCallbacks(this);
        }

        public void startUsingVelocity(int initialVelocity) {
            if (initialVelocity != 0 && MyGallery.this.mSingleContentWidth != 0) {
                int initialX;
                startCommon();
                if (initialVelocity < 0) {
                    initialX = 2147473647;
                } else {
                    initialX = 0;
                }
                this.mLastFlingX = initialX;
                this.mScroller.fling(initialX, 0, initialVelocity, 0, 0, 2147473647, 0, 2147473647, MyGallery.this.getCurOffset(), MyGallery.this.mSingleContentWidth);
                MyGallery.this.post(this);
            }
        }

        public void startUsingDistance(int distance, boolean sharp, int value) {
            if (distance != 0) {
                int -get0;
                startCommon();
                this.mLastFlingX = 0;
                MyScroller myScroller = this.mScroller;
                int i = -distance;
                if (sharp) {
                    -get0 = MyGallery.this.mAnimationDuration;
                } else {
                    -get0 = value;
                }
                myScroller.startScroll(0, 0, i, 0, -get0);
                MyGallery.this.post(this);
            }
        }

        public void stop(boolean scrollIntoSlots) {
            MyGallery.this.removeCallbacks(this);
            endFling(scrollIntoSlots);
        }

        private void endFling(boolean scrollIntoSlots) {
            this.mScroller.forceFinished(true);
            if (scrollIntoSlots) {
                MyGallery.this.scrollIntoSlots(false);
            }
        }

        public void run() {
            if (MyGallery.this.mItemCount == 0) {
                endFling(true);
                return;
            }
            MyGallery.this.mShouldStopFling = false;
            MyScroller scroller = this.mScroller;
            boolean more = scroller.computeScrollOffset();
            int x = scroller.getCurrX();
            int delta = this.mLastFlingX - x;
            MyGallery myGallery;
            int childCount;
            if (delta > 0) {
                myGallery = MyGallery.this;
                if (MyGallery.this.mIsRtl) {
                    childCount = (MyGallery.this.mFirstPosition + MyGallery.this.getChildCount()) - 1;
                } else {
                    childCount = MyGallery.this.mFirstPosition;
                }
                myGallery.mDownTouchPosition = childCount;
                delta = Math.min(((MyGallery.this.getWidth() - MyGallery.this.getPaddingLeft()) - MyGallery.this.getPaddingRight()) - 1, delta);
            } else {
                myGallery = MyGallery.this;
                if (MyGallery.this.mIsRtl) {
                    childCount = MyGallery.this.mFirstPosition;
                } else {
                    childCount = (MyGallery.this.mFirstPosition + MyGallery.this.getChildCount()) - 1;
                }
                myGallery.mDownTouchPosition = childCount;
                delta = Math.max(-(((MyGallery.this.getWidth() - MyGallery.this.getPaddingRight()) - MyGallery.this.getPaddingLeft()) - 1), delta);
            }
            MyGallery.this.trackMotionScroll(delta);
            if (!more || MyGallery.this.mShouldStopFling) {
                endFling(true);
            } else {
                this.mLastFlingX = x;
                MyGallery.this.post(this);
            }
        }
    }

    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public LayoutParams(int w, int h) {
            super(w, h);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams source) {
            super(source);
        }
    }

    public MyGallery(Context context) {
        this(context, null);
    }

    public MyGallery(Context context, AttributeSet attrs) {
        this(context, attrs, R.style.MyGallery);
    }

    public MyGallery(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mSpacing = 0;
        this.mAnimationDuration = AbsAlbumPage.LAUNCH_QUIK_ACTIVITY;
        this.mFlingRunnable = new FlingRunnable();
        this.mDisableSuppressSelectionChangedRunnable = new Runnable() {
            public void run() {
                MyGallery.this.mSuppressSelectionChanged = false;
                MyGallery.this.selectionChanged();
            }
        };
        this.mShouldCallbackDuringFling = true;
        this.mShouldCallbackOnUnselectedItemClick = true;
        this.mIsRtl = true;
        this.mGestureDetector = new GestureDetector(context, this);
        this.mGestureDetector.setIsLongpressEnabled(false);
        TypedArray a = context.obtainStyledAttributes(attrs, R$styleable.MyGallery, defStyle, 0);
        int index = a.getInt(0, 16);
        if (index >= 0) {
            setGravity(index);
        }
        int animationDuration = a.getInt(1, -1);
        if (animationDuration > 0) {
            setAnimationDuration(animationDuration);
        }
        setSpacing(a.getDimensionPixelOffset(2, 0));
        setUnselectedAlpha(a.getFloat(3, 0.5f));
        a.recycle();
    }

    public void setCallbackDuringFling(boolean shouldCallback) {
        this.mShouldCallbackDuringFling = shouldCallback;
    }

    public void setAnimationDuration(int animationDurationMillis) {
        this.mAnimationDuration = animationDurationMillis;
    }

    public void setSpacing(int spacing) {
        this.mSpacing = spacing;
    }

    public int getSpacing() {
        return this.mSpacing;
    }

    public void setUnselectedAlpha(float unselectedAlpha) {
        this.mUnselectedAlpha = unselectedAlpha;
    }

    protected boolean getChildStaticTransformation(View child, Transformation t) {
        t.clear();
        t.setAlpha(child == this.mSelectedChild ? WMElement.CAMERASIZEVALUE1B1 : this.mUnselectedAlpha);
        return true;
    }

    protected int computeHorizontalScrollExtent() {
        return 1;
    }

    protected int computeHorizontalScrollOffset() {
        return this.mSelectedPosition;
    }

    protected int computeHorizontalScrollRange() {
        return this.mItemCount;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams;
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        this.mInLayout = true;
        layout(0, false);
        this.mInLayout = false;
        this.mSingleContentWidth = getSingleContentWidth();
    }

    int getChildHeight(View child) {
        return child.getMeasuredHeight();
    }

    protected void trackMotionScroll(int deltaX) {
        if (getChildCount() != 0) {
            boolean toLeft;
            if (deltaX < 0) {
                toLeft = true;
            } else {
                toLeft = false;
            }
            int limitedDeltaX = getLimitedMotionScrollAmount(toLeft, deltaX);
            if (limitedDeltaX != deltaX) {
                this.mFlingRunnable.endFling(false);
                onFinishedMovement();
            }
            offsetChildrenLeftAndRight(limitedDeltaX);
            detachOffScreenChildren(toLeft);
            if (toLeft) {
                fillToGalleryRight();
            } else {
                fillToGalleryLeft();
            }
            this.mRecycler.clear();
            setSelectionToCenterChild();
            View selChild = this.mSelectedChild;
            if (selChild != null) {
                int galleryCenter = getWidth() / 2;
                this.mSelectedCenterOffset = (selChild.getLeft() + (selChild.getWidth() / 2)) - galleryCenter;
            }
            onScrollChanged(0, 0, 0, 0);
            invalidate();
        }
    }

    int getLimitedMotionScrollAmount(boolean motionToLeft, int deltaX) {
        View extremeChild = getChildAt((motionToLeft != this.mIsRtl ? this.mItemCount - 1 : 0) - this.mFirstPosition);
        if (extremeChild == null) {
            return deltaX;
        }
        int max;
        int extremeChildCenter = getCenterOfView(extremeChild);
        int galleryCenter = getCenterOfGallery();
        if (motionToLeft) {
            if (extremeChildCenter <= galleryCenter) {
                return 0;
            }
        } else if (extremeChildCenter >= galleryCenter) {
            return 0;
        }
        int centerDifference = galleryCenter - extremeChildCenter;
        if (motionToLeft) {
            max = Math.max(centerDifference, deltaX);
        } else {
            max = Math.min(centerDifference, deltaX);
        }
        return max;
    }

    private void offsetChildrenLeftAndRight(int offset) {
        for (int i = getChildCount() - 1; i >= 0; i--) {
            getChildAt(i).offsetLeftAndRight(offset);
        }
    }

    protected int getCenterOfGallery() {
        return (((getWidth() - getPaddingLeft()) - getPaddingRight()) / 2) + getPaddingLeft();
    }

    public static int getCenterOfView(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private void detachOffScreenChildren(boolean toLeft) {
        int numChildren = getChildCount();
        int firstPosition = this.mFirstPosition;
        int start = 0;
        int count = 0;
        int i;
        int n;
        View child;
        if (toLeft) {
            int galleryLeft = getPaddingLeft();
            for (i = 0; i < numChildren; i++) {
                if (this.mIsRtl) {
                    n = (numChildren - 1) - i;
                } else {
                    n = i;
                }
                child = getChildAt(n);
                if (child.getRight() >= galleryLeft) {
                    break;
                }
                start = n;
                count++;
                this.mRecycler.put(firstPosition + n, child);
            }
            if (!this.mIsRtl) {
                start = 0;
            }
        } else {
            int galleryRight = getWidth() - getPaddingRight();
            i = numChildren - 1;
            while (i >= 0) {
                n = this.mIsRtl ? (numChildren - 1) - i : i;
                child = getChildAt(n);
                if (child.getLeft() <= galleryRight) {
                    break;
                }
                start = n;
                count++;
                this.mRecycler.put(firstPosition + n, child);
                i--;
            }
            if (this.mIsRtl) {
                start = 0;
            }
        }
        detachViewsFromParent(start, count);
        if (toLeft != this.mIsRtl) {
            this.mFirstPosition += count;
        }
    }

    private void scrollIntoSlots(boolean sharp) {
        if (getChildCount() != 0 && this.mSelectedChild != null) {
            int scrollAmount = getCenterOfGallery() - getCenterOfView(this.mSelectedChild);
            if (scrollAmount != 0) {
                this.mFlingRunnable.startUsingDistance(scrollAmount, sharp, 1000);
            } else {
                onFinishedMovement();
            }
        }
    }

    protected void onFinishedMovement() {
        if (this.mSuppressSelectionChanged) {
            this.mSuppressSelectionChanged = false;
            super.selectionChanged();
        }
        this.mSelectedCenterOffset = 0;
        invalidate();
    }

    public int getSelectedViewOffset() {
        if (getChildCount() == 0 || this.mSelectedChild == null) {
            return 0;
        }
        return getCenterOfGallery() - getCenterOfView(this.mSelectedChild);
    }

    void selectionChanged() {
        if (!this.mSuppressSelectionChanged) {
            super.selectionChanged();
        }
    }

    private void setSelectionToCenterChild() {
        View selView = this.mSelectedChild;
        if (this.mSelectedChild != null) {
            int galleryCenter = getCenterOfGallery();
            if (selView.getLeft() > galleryCenter || selView.getRight() < galleryCenter) {
                int closestEdgeDistance = Integer.MAX_VALUE;
                int newSelectedChildIndex = 0;
                for (int i = getChildCount() - 1; i >= 0; i--) {
                    View child = getChildAt(i);
                    if (child.getLeft() <= galleryCenter && child.getRight() >= galleryCenter) {
                        newSelectedChildIndex = i;
                        break;
                    }
                    int childClosestEdgeDistance = Math.min(Math.abs(child.getLeft() - galleryCenter), Math.abs(child.getRight() - galleryCenter));
                    if (childClosestEdgeDistance < closestEdgeDistance) {
                        closestEdgeDistance = childClosestEdgeDistance;
                        newSelectedChildIndex = i;
                    }
                }
                int newPos = this.mFirstPosition + newSelectedChildIndex;
                if (newPos != this.mSelectedPosition) {
                    setSelectedPositionInt(newPos);
                    setNextSelectedPositionInt(newPos);
                    checkSelectionChanged();
                }
            }
        }
    }

    public boolean isLayoutRtl() {
        return getLayoutDirection() == 1;
    }

    protected void layout(int delta, boolean animate) {
        this.mIsRtl = isLayoutRtl();
        int childrenLeft = this.mSpinnerPadding.left;
        int childrenWidth = ((getRight() - getLeft()) - this.mSpinnerPadding.left) - this.mSpinnerPadding.right;
        if (this.mDataChanged) {
            handleDataChanged();
        }
        if (this.mItemCount == 0) {
            resetList();
            return;
        }
        if (this.mNextSelectedPosition >= 0) {
            setSelectedPositionInt(this.mNextSelectedPosition);
        }
        recycleAllViews();
        detachAllViewsFromParent();
        this.mRightMost = 0;
        this.mLeftMost = 0;
        this.mFirstPosition = this.mSelectedPosition;
        View sel = makeAndAddView(this.mSelectedPosition, 0, 0, true);
        sel.offsetLeftAndRight((((childrenWidth / 2) + childrenLeft) - (sel.getWidth() / 2)) + this.mSelectedCenterOffset);
        fillToGalleryRight();
        fillToGalleryLeft();
        this.mRecycler.clear();
        invalidate();
        checkSelectionChanged();
        this.mDataChanged = false;
        this.mNeedSync = false;
        setNextSelectedPositionInt(this.mSelectedPosition);
        updateSelectedItemMetadata();
    }

    private void fillToGalleryLeft() {
        if (this.mIsRtl) {
            fillToGalleryLeftRtl();
        } else {
            fillToGalleryLeftLtr();
        }
    }

    private void fillToGalleryLeftRtl() {
        int curPosition;
        int curRightEdge;
        int itemSpacing = this.mSpacing;
        int galleryLeft = getPaddingLeft();
        int numChildren = getChildCount();
        int numItems = this.mItemCount;
        View prevIterationView = getChildAt(numChildren - 1);
        if (prevIterationView != null) {
            curPosition = this.mFirstPosition + numChildren;
            curRightEdge = prevIterationView.getLeft() - itemSpacing;
        } else {
            curPosition = this.mItemCount - 1;
            this.mFirstPosition = curPosition;
            curRightEdge = (getRight() - getLeft()) - getPaddingRight();
            this.mShouldStopFling = true;
        }
        while (curRightEdge > galleryLeft && curPosition < this.mItemCount) {
            curRightEdge = makeAndAddView(curPosition, curPosition - this.mSelectedPosition, curRightEdge, false).getLeft() - itemSpacing;
            curPosition++;
        }
    }

    private void fillToGalleryLeftLtr() {
        int curPosition;
        int curRightEdge;
        int itemSpacing = this.mSpacing;
        int galleryLeft = getPaddingLeft();
        View prevIterationView = getChildAt(0);
        if (prevIterationView != null) {
            curPosition = this.mFirstPosition - 1;
            curRightEdge = prevIterationView.getLeft() - itemSpacing;
        } else {
            curPosition = 0;
            curRightEdge = (getRight() - getLeft()) - getPaddingRight();
            this.mShouldStopFling = true;
        }
        while (curRightEdge > galleryLeft && curPosition >= 0) {
            prevIterationView = makeAndAddView(curPosition, curPosition - this.mSelectedPosition, curRightEdge, false);
            this.mFirstPosition = curPosition;
            curRightEdge = prevIterationView.getLeft() - itemSpacing;
            curPosition--;
        }
    }

    private void fillToGalleryRight() {
        if (this.mIsRtl) {
            fillToGalleryRightRtl();
        } else {
            fillToGalleryRightLtr();
        }
    }

    private void fillToGalleryRightRtl() {
        int curPosition;
        int curLeftEdge;
        int itemSpacing = this.mSpacing;
        int galleryRight = (getRight() - getLeft()) - getPaddingRight();
        View prevIterationView = getChildAt(0);
        if (prevIterationView != null) {
            curPosition = this.mFirstPosition - 1;
            curLeftEdge = prevIterationView.getRight() + itemSpacing;
        } else {
            curPosition = 0;
            curLeftEdge = getPaddingLeft();
            this.mShouldStopFling = true;
        }
        while (curLeftEdge < galleryRight && curPosition >= 0) {
            prevIterationView = makeAndAddView(curPosition, curPosition - this.mSelectedPosition, curLeftEdge, true);
            this.mFirstPosition = curPosition;
            curLeftEdge = prevIterationView.getRight() + itemSpacing;
            curPosition--;
        }
    }

    private void fillToGalleryRightLtr() {
        int curPosition;
        int curLeftEdge;
        int itemSpacing = this.mSpacing;
        int galleryRight = (getRight() - getLeft()) - getPaddingRight();
        int numChildren = getChildCount();
        int numItems = this.mItemCount;
        View prevIterationView = getChildAt(numChildren - 1);
        if (prevIterationView != null) {
            curPosition = this.mFirstPosition + numChildren;
            curLeftEdge = prevIterationView.getRight() + itemSpacing;
        } else {
            curPosition = this.mItemCount - 1;
            this.mFirstPosition = curPosition;
            curLeftEdge = getPaddingLeft();
            this.mShouldStopFling = true;
        }
        while (curLeftEdge < galleryRight && curPosition < numItems) {
            curLeftEdge = makeAndAddView(curPosition, curPosition - this.mSelectedPosition, curLeftEdge, true).getRight() + itemSpacing;
            curPosition++;
        }
    }

    private View makeAndAddView(int position, int offset, int x, boolean fromLeft) {
        View child;
        if (!this.mDataChanged) {
            child = this.mRecycler.get(position);
            if (child != null) {
                int childLeft = child.getLeft();
                this.mRightMost = Math.max(this.mRightMost, child.getMeasuredWidth() + childLeft);
                this.mLeftMost = Math.min(this.mLeftMost, childLeft);
                setUpChild(child, offset, x, fromLeft);
                return child;
            }
        }
        child = this.mAdapter.getView(position, null, this);
        setUpChild(child, offset, x, fromLeft);
        return child;
    }

    private void setUpChild(View child, int offset, int x, boolean fromLeft) {
        int childLeft;
        int childRight;
        LayoutParams lp = (LayoutParams) child.getLayoutParams();
        if (lp == null) {
            lp = (LayoutParams) generateDefaultLayoutParams();
        }
        addViewInLayout(child, fromLeft != this.mIsRtl ? -1 : 0, lp, true);
        child.setSelected(offset == 0);
        child.measure(ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mSpinnerPadding.left + this.mSpinnerPadding.right, lp.width), ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, this.mSpinnerPadding.top + this.mSpinnerPadding.bottom, lp.height));
        int childTop = calculateTop(child, true);
        int childBottom = childTop + child.getMeasuredHeight();
        int width = child.getMeasuredWidth();
        if (fromLeft) {
            childLeft = x;
            childRight = x + width;
        } else {
            childLeft = x - width;
            childRight = x;
        }
        child.layout(childLeft, childTop, childRight, childBottom);
    }

    private int calculateTop(View child, boolean duringLayout) {
        int myHeight = duringLayout ? getMeasuredHeight() : getHeight();
        int childHeight = duringLayout ? child.getMeasuredHeight() : child.getHeight();
        switch (this.mGravity) {
            case 16:
                return this.mSpinnerPadding.top + ((((myHeight - this.mSpinnerPadding.bottom) - this.mSpinnerPadding.top) - childHeight) / 2);
            case 48:
                return this.mSpinnerPadding.top;
            case 80:
                return (myHeight - this.mSpinnerPadding.bottom) - childHeight;
            default:
                return 0;
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        boolean retValue = this.mGestureDetector.onTouchEvent(event);
        if (action == 1) {
            onUp();
        } else if (action == 3) {
            onCancel();
        }
        return retValue;
    }

    public boolean onSingleTapUp(MotionEvent e) {
        if (this.mDownTouchPosition < 0) {
            return false;
        }
        scrollToChild(this.mDownTouchPosition - this.mFirstPosition);
        if (this.mShouldCallbackOnUnselectedItemClick || this.mDownTouchPosition == this.mSelectedPosition) {
            performItemClick(this.mDownTouchView, this.mDownTouchPosition, this.mAdapter.getItemId(this.mDownTouchPosition));
        }
        return true;
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (!this.mShouldCallbackDuringFling) {
            removeCallbacks(this.mDisableSuppressSelectionChangedRunnable);
            if (!this.mSuppressSelectionChanged) {
                this.mSuppressSelectionChanged = true;
            }
        }
        this.mFlingRunnable.startUsingVelocity((int) (-velocityX));
        return true;
    }

    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.mShouldCallbackDuringFling) {
            if (this.mSuppressSelectionChanged) {
                this.mSuppressSelectionChanged = false;
            }
        } else if (this.mIsFirstScroll) {
            if (!this.mSuppressSelectionChanged) {
                this.mSuppressSelectionChanged = true;
            }
            postDelayed(this.mDisableSuppressSelectionChangedRunnable, 250);
        }
        if (!this.mIsFirstScroll) {
            trackMotionScroll(((int) distanceX) * -1);
        }
        this.mIsFirstScroll = false;
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onDown(MotionEvent e) {
        this.mFlingRunnable.stop(false);
        this.mDownTouchPosition = pointToPosition((int) e.getX(), (int) e.getY());
        if (this.mDownTouchPosition >= 0) {
            this.mDownTouchView = getChildAt(this.mDownTouchPosition - this.mFirstPosition);
            this.mDownTouchView.setPressed(true);
        }
        this.mIsFirstScroll = true;
        return true;
    }

    void onUp() {
        if (this.mFlingRunnable.mScroller.isFinished()) {
            scrollIntoSlots(true);
        }
        dispatchUnpress();
    }

    void onCancel() {
        onUp();
    }

    public void onShowPress(MotionEvent e) {
    }

    private void dispatchPress(View child) {
        if (child != null) {
            child.setPressed(true);
        }
        setPressed(true);
    }

    private void dispatchUnpress() {
        for (int i = getChildCount() - 1; i >= 0; i--) {
            getChildAt(i).setPressed(false);
        }
        setPressed(false);
    }

    public void dispatchSetSelected(boolean selected) {
    }

    protected void dispatchSetPressed(boolean pressed) {
        if (this.mSelectedChild != null) {
            this.mSelectedChild.setPressed(pressed);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        return event.dispatch(this, null, null);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case 21:
                if (movePrevious()) {
                    playSoundEffect(1);
                    return true;
                }
                break;
            case 22:
                if (moveNext()) {
                    playSoundEffect(3);
                    return true;
                }
                break;
            case 23:
            case 66:
                this.mReceivedInvokeKeyDown = true;
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    public static final boolean isConfirmKey(int keyCode) {
        switch (keyCode) {
            case 23:
            case 66:
                return true;
            default:
                return false;
        }
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (!isConfirmKey(keyCode)) {
            return super.onKeyUp(keyCode, event);
        }
        if (this.mReceivedInvokeKeyDown && this.mItemCount > 0) {
            dispatchPress(this.mSelectedChild);
            postDelayed(new Runnable() {
                public void run() {
                    MyGallery.this.dispatchUnpress();
                }
            }, (long) ViewConfiguration.getPressedStateDuration());
            performItemClick(getChildAt(this.mSelectedPosition - this.mFirstPosition), this.mSelectedPosition, this.mAdapter.getItemId(this.mSelectedPosition));
        }
        this.mReceivedInvokeKeyDown = false;
        return true;
    }

    boolean movePrevious() {
        if (this.mItemCount <= 0 || this.mSelectedPosition <= 0) {
            return false;
        }
        scrollToChild((this.mSelectedPosition - this.mFirstPosition) - 1);
        return true;
    }

    boolean moveNext() {
        if (this.mItemCount <= 0 || this.mSelectedPosition >= this.mItemCount - 1) {
            return false;
        }
        scrollToChild((this.mSelectedPosition - this.mFirstPosition) + 1);
        return true;
    }

    public boolean scrollToPosition(int childPosition, boolean sharp) {
        int count = this.mSelectedPosition - childPosition;
        this.mFlingRunnable.startUsingDistance(count * getSingleContentWidth(), sharp, Math.abs(count) * 180);
        return true;
    }

    protected boolean scrollToChild(int childPosition) {
        View child = getChildAt(childPosition);
        if (child == null) {
            return false;
        }
        this.mFlingRunnable.startUsingDistance(getCenterOfGallery() - getCenterOfView(child), true, 0);
        return true;
    }

    void setSelectedPositionInt(int position) {
        super.setSelectedPositionInt(position);
        updateSelectedItemMetadata();
    }

    private void updateSelectedItemMetadata() {
        View oldSelectedChild = this.mSelectedChild;
        View child = getChildAt(this.mSelectedPosition - this.mFirstPosition);
        this.mSelectedChild = child;
        if (child != null) {
            child.setSelected(true);
            child.setFocusable(true);
            if (hasFocus()) {
                child.requestFocus();
            }
            if (!(oldSelectedChild == null || oldSelectedChild == child)) {
                oldSelectedChild.setSelected(false);
                oldSelectedChild.setFocusable(false);
            }
        }
    }

    public void setGravity(int gravity) {
        if (this.mGravity != gravity) {
            this.mGravity = gravity;
            requestLayout();
        }
    }

    protected int getChildDrawingOrder(int childCount, int i) {
        int selectedIndex = this.mSelectedPosition - this.mFirstPosition;
        if (selectedIndex < 0) {
            return i;
        }
        if (i == childCount - 1) {
            return selectedIndex;
        }
        if (i >= selectedIndex) {
            return i + 1;
        }
        return i;
    }

    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if (gainFocus && this.mSelectedChild != null) {
            this.mSelectedChild.requestFocus(direction);
            this.mSelectedChild.setSelected(true);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setClassName(MyGallery.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        boolean z = true;
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(MyGallery.class.getName());
        if (this.mItemCount <= 1) {
            z = false;
        }
        info.setScrollable(z);
        if (isEnabled()) {
            if (this.mItemCount > 0 && this.mSelectedPosition < this.mItemCount - 1) {
                info.addAction(FragmentTransaction.TRANSIT_ENTER_MASK);
            }
            if (isEnabled() && this.mItemCount > 0 && this.mSelectedPosition > 0) {
                info.addAction(FragmentTransaction.TRANSIT_EXIT_MASK);
            }
        }
    }

    public boolean performAccessibilityAction(int action, Bundle arguments) {
        if (super.performAccessibilityAction(action, arguments)) {
            return true;
        }
        switch (action) {
            case FragmentTransaction.TRANSIT_ENTER_MASK /*4096*/:
                if (!isEnabled() || this.mItemCount <= 0 || this.mSelectedPosition >= this.mItemCount - 1) {
                    return false;
                }
                return scrollToChild((this.mSelectedPosition - this.mFirstPosition) + 1);
            case FragmentTransaction.TRANSIT_EXIT_MASK /*8192*/:
                if (!isEnabled() || this.mItemCount <= 0 || this.mSelectedPosition <= 0) {
                    return false;
                }
                return scrollToChild((this.mSelectedPosition - this.mFirstPosition) - 1);
            default:
                return false;
        }
    }

    private int getSingleContentWidth() {
        View view = getChildAt(0);
        if (view != null) {
            return view.getWidth() + this.mSpacing;
        }
        return 0;
    }

    private int getCurOffset() {
        if (this.mSingleContentWidth == 0) {
            return 0;
        }
        return this.mSelectedCenterOffset % this.mSingleContentWidth;
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }
}
