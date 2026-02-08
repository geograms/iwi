package com.google.android.material.tabs;

import androidx.recyclerview.widget.v0;
import androidx.recyclerview.widget.x0;
import com.google.android.material.tabs.TabLayout;
import i0.a;
import java.lang.ref.WeakReference;
import x0.g;

/* loaded from: classes.dex */
public final class TabLayoutMediator {
    private v0 adapter;
    private boolean attached;
    private final boolean autoRefresh;
    private TabLayoutOnPageChangeCallback onPageChangeCallback;
    private TabLayout.OnTabSelectedListener onTabSelectedListener;
    private x0 pagerAdapterObserver;
    private final boolean smoothScroll;
    private final TabConfigurationStrategy tabConfigurationStrategy;
    private final TabLayout tabLayout;
    private final a viewPager;

    public class PagerAdapterObserver extends x0 {
        public PagerAdapterObserver() {
        }

        @Override // androidx.recyclerview.widget.x0
        public void onChanged() {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        public void onItemRangeChanged(int i2, int i3) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.x0
        public void onItemRangeInserted(int i2, int i3) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.x0
        public void onItemRangeMoved(int i2, int i3, int i4) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.x0
        public void onItemRangeRemoved(int i2, int i3) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.x0
        public void onItemRangeChanged(int i2, int i3, Object obj) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }
    }

    public interface TabConfigurationStrategy {
        void onConfigureTab(TabLayout.Tab tab, int i2);
    }

    public static class TabLayoutOnPageChangeCallback extends g {
        private int previousScrollState;
        private int scrollState;
        private final WeakReference<TabLayout> tabLayoutRef;

        public TabLayoutOnPageChangeCallback(TabLayout tabLayout) {
            this.tabLayoutRef = new WeakReference<>(tabLayout);
            reset();
        }

        public void onPageScrollStateChanged(int i2) {
            this.previousScrollState = this.scrollState;
            this.scrollState = i2;
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null) {
                tabLayout.updateViewPagerScrollState(this.scrollState);
            }
        }

        public void onPageScrolled(int i2, float f2, int i3) {
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null) {
                int i4 = this.scrollState;
                tabLayout.setScrollPosition(i2, f2, i4 != 2 || this.previousScrollState == 1, (i4 == 2 && this.previousScrollState == 0) ? false : true, false);
            }
        }

        public void onPageSelected(int i2) {
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i2 || i2 >= tabLayout.getTabCount()) {
                return;
            }
            int i3 = this.scrollState;
            tabLayout.selectTab(tabLayout.getTabAt(i2), i3 == 0 || (i3 == 2 && this.previousScrollState == 0));
        }

        public void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }
    }

    public static class ViewPagerOnTabSelectedListener implements TabLayout.OnTabSelectedListener {
        private final boolean smoothScroll;
        private final a viewPager;

        public ViewPagerOnTabSelectedListener(a aVar, boolean z2) {
            this.smoothScroll = z2;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            tab.getPosition();
            throw null;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    public TabLayoutMediator(TabLayout tabLayout, a aVar, TabConfigurationStrategy tabConfigurationStrategy) {
        this(tabLayout, aVar, true, tabConfigurationStrategy);
    }

    public void attach() {
        if (!this.attached) {
            throw null;
        }
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }

    public void detach() {
        v0 v0Var;
        if (this.autoRefresh && (v0Var = this.adapter) != null) {
            v0Var.unregisterAdapterDataObserver(this.pagerAdapterObserver);
            this.pagerAdapterObserver = null;
        }
        this.tabLayout.removeOnTabSelectedListener(this.onTabSelectedListener);
        throw null;
    }

    public boolean isAttached() {
        return this.attached;
    }

    public void populateTabsFromPagerAdapter() {
        this.tabLayout.removeAllTabs();
        v0 v0Var = this.adapter;
        if (v0Var != null) {
            int itemCount = v0Var.getItemCount();
            for (int i2 = 0; i2 < itemCount; i2++) {
                TabLayout.Tab tabNewTab = this.tabLayout.newTab();
                this.tabConfigurationStrategy.onConfigureTab(tabNewTab, i2);
                this.tabLayout.addTab(tabNewTab, false);
            }
            if (itemCount <= 0) {
                return;
            }
            this.tabLayout.getTabCount();
            throw null;
        }
    }

    public TabLayoutMediator(TabLayout tabLayout, a aVar, boolean z2, TabConfigurationStrategy tabConfigurationStrategy) {
        this(tabLayout, aVar, z2, true, tabConfigurationStrategy);
    }

    public TabLayoutMediator(TabLayout tabLayout, a aVar, boolean z2, boolean z3, TabConfigurationStrategy tabConfigurationStrategy) {
        this.tabLayout = tabLayout;
        this.autoRefresh = z2;
        this.smoothScroll = z3;
        this.tabConfigurationStrategy = tabConfigurationStrategy;
    }
}
