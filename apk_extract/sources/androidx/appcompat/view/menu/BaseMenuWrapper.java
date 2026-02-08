package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import g.l;
import m.b;

/* loaded from: classes.dex */
abstract class BaseMenuWrapper {
    final Context mContext;
    private l mMenuItems;
    private l mSubMenus;

    public BaseMenuWrapper(Context context) {
        this.mContext = context;
    }

    public final MenuItem getMenuItemWrapper(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (this.mMenuItems == null) {
            this.mMenuItems = new l();
        }
        MenuItem menuItem2 = (MenuItem) this.mMenuItems.getOrDefault(bVar, null);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS(this.mContext, bVar);
        this.mMenuItems.put(bVar, menuItemWrapperICS);
        return menuItemWrapperICS;
    }

    public final SubMenu getSubMenuWrapper(SubMenu subMenu) {
        return subMenu;
    }

    public final void internalClear() {
        l lVar = this.mMenuItems;
        if (lVar != null) {
            lVar.clear();
        }
        l lVar2 = this.mSubMenus;
        if (lVar2 != null) {
            lVar2.clear();
        }
    }

    public final void internalRemoveGroup(int i2) {
        if (this.mMenuItems == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            l lVar = this.mMenuItems;
            if (i3 >= lVar.f1812c) {
                return;
            }
            if (((b) lVar.h(i3)).getGroupId() == i2) {
                this.mMenuItems.i(i3);
                i3--;
            }
            i3++;
        }
    }

    public final void internalRemoveItem(int i2) {
        if (this.mMenuItems == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            l lVar = this.mMenuItems;
            if (i3 >= lVar.f1812c) {
                return;
            }
            if (((b) lVar.h(i3)).getItemId() == i2) {
                this.mMenuItems.i(i3);
                return;
            }
            i3++;
        }
    }
}
