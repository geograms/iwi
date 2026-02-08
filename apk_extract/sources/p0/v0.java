package p0;

import androidx.lifecycle.Observer;
import com.chamsion.quickchat.ui.MessageChatActivity;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class v0 implements Observer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2457a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MessageChatActivity f2458b;

    public /* synthetic */ v0(MessageChatActivity messageChatActivity, int i2) {
        this.f2457a = i2;
        this.f2458b = messageChatActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        int i2 = this.f2457a;
        MessageChatActivity messageChatActivity = this.f2458b;
        switch (i2) {
            case 0:
                messageChatActivity.f1444g = (k0.a) obj;
                messageChatActivity.d();
                break;
            case 1:
                List<k0.a> list = (List) obj;
                int i3 = MessageChatActivity.f1437o;
                messageChatActivity.getClass();
                if (list != null) {
                    for (k0.a aVar : list) {
                        if (aVar.f1942f) {
                            messageChatActivity.f1444g = aVar;
                            messageChatActivity.f1447j = aVar.f1937a;
                            messageChatActivity.f1446i = aVar.f1953q;
                            messageChatActivity.f1445h = aVar.f1952p;
                            messageChatActivity.d();
                        }
                    }
                    break;
                }
                break;
            default:
                List list2 = (List) obj;
                if (list2 != null) {
                    messageChatActivity.f1449l.f890a.b(list2, null);
                    if (!list2.isEmpty()) {
                        messageChatActivity.f1441d.scrollToPosition(list2.size() - 1);
                        break;
                    }
                } else {
                    int i4 = MessageChatActivity.f1437o;
                    messageChatActivity.getClass();
                    break;
                }
                break;
        }
    }
}
