package LIST;
import MUONSACH.NguoiMuon;

public class ListNguoiMuon {
    private NodeNguoiMuon head, tail;

    public ListNguoiMuon() {
        this.head = null;
        this.tail = null;
    }

    public NodeNguoiMuon getHead() {
        return head;
    }

    public NodeNguoiMuon getTail() {
        return tail;
    }

    public void insertHead(NguoiMuon nguoiMuon) {
        NodeNguoiMuon newNode = new NodeNguoiMuon(nguoiMuon);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.setNext(head); // Gán newNode vào đầu danh sách.
            head = newNode;           // cập nhật lại vị trí đầu của danh sách.
        }
    }

    public void insertTail(NguoiMuon nguoiMuon) {
        NodeNguoiMuon newNode = new NodeNguoiMuon(nguoiMuon);
        if (head == null) head = tail = newNode;
        else {
            tail.setNext(newNode);      // Gán newNode vào cuối danh sách.
            tail = newNode;               // Cập nhật lại vị trí cuối của danh sách.
        }
    }

    public void deleteNode(NodeNguoiMuon nodeNguoiMuon) {
        NodeNguoiMuon tg = head;
        NodeNguoiMuon t = tg;
        while (tg != null) {
            if (tg == nodeNguoiMuon) break;
            else {
                t = tg;
                tg = tg.getNext();
            }
        }

        if (tg == null) return; // Không tồn tại nodeMayAnh.
        if (t != null)          // Tồn tại
        {
            t.setNext(tg.getNext());
            tg = null;
        } else // nếu là đầu danh sách.
        {
            head = tg.getNext();
        }
    }

    public void removeNode(NodeNguoiMuon nodeNguoiMuon) {
        NodeNguoiMuon tg = head;
        NodeNguoiMuon t = tg;
        while (tg != null) {
            if (tg == nodeNguoiMuon) {
                break;
            } else {
                t = tg;
                tg = tg.getNext();
            }
        }
        if (tg == head) head = head.getNext(); // Nếu node ở đầu danh sách.
        else {
            if (tg.getNext() == null) {
                t = null; // Nếu node ở cuối danh sách.
            } else {
                t.setNext(tg.getNext());
            }
        }


    }


    public void sapXepTheoTen() {
        NguoiMuon tmp;
        String loai1;
        String loai2;
        if (head == null) return;
        NodeNguoiMuon tg = head, p;
        while (tg.getNext() != null) {
            p = tg.getNext();
            loai1 = tg.getInfo().getTenNguoiMuon().split(" ")[tg.getInfo().getTenNguoiMuon().split(" ").length - 1];
            while (p != null) {
                loai2 = p.getInfo().getTenNguoiMuon().split(" ")[p.getInfo().getTenNguoiMuon().split(" ").length - 1];
                if (loai1.compareToIgnoreCase(loai2) > 0) {
                    loai1 = loai2;
                    tmp = tg.getInfo();
                    tg.setInfo(p.getInfo());
                    p.setInfo(tmp);
                }
                p = p.getNext();
            }
            tg = tg.getNext();
        }

    }



    public class NodeNguoiMuon {
        private NguoiMuon info;
        private NodeNguoiMuon next;

        public NodeNguoiMuon() {
            this.info = new NguoiMuon();
            next = null;
        }

        public NodeNguoiMuon(NguoiMuon info) {
            this.info = info;
        }

        public NguoiMuon getInfo() {
            return info;
        }

        public void setInfo(NguoiMuon info) {
            this.info = info;
        }

        public NodeNguoiMuon getNext() {
            return next;
        }

        public void setNext(NodeNguoiMuon next) {
            this.next = next;
        }
    }

}
