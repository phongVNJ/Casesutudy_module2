package LIST;
import MUONSACH.PhieuMuon;

public class ListPhieuMuon {
    private NodePhieuMuon head, tail;

    public ListPhieuMuon() {
        this.head = null;
        this.tail = null;
    }

    public NodePhieuMuon getHead() {
        return head;
    }

    public NodePhieuMuon getTail() {
        return tail;
    }

    public void insertHead(PhieuMuon phieuMuon) {
        NodePhieuMuon newNode = new NodePhieuMuon(phieuMuon);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.setNext(head); // Gán newNode vào đầu danh sách.
            head = newNode;           // cập nhật lại vị trí đầu của danh sách.
        }
    }

    public void insertTail(PhieuMuon phieuMuon) {
        NodePhieuMuon newNode = new NodePhieuMuon(phieuMuon);
        if (head == null) head = tail = newNode;
        else {
            tail.setNext(newNode);      // Gán newNode vào cuối danh sách.
            tail = newNode;               // Cập nhật lại vị trí cuối của danh sách.
        }
    }

    public void deleteNode(NodePhieuMuon nodePhieuMuon) {
        NodePhieuMuon tg = head;
        NodePhieuMuon t = tg;
        while (tg != null) {
            if (tg == nodePhieuMuon) break;
            else {
                t = tg;
                tg = tg.getNext();
            }
        }

        if (tg == null) return; // Không tồn tại node.
        if (t != null)          // Tồn tại
        {
            t.setNext(tg.getNext());
            tg = null;
        } else // nếu là đầu danh sách.
        {
            head = tg.getNext();
        }
    }

    public void removeNode(NodePhieuMuon nodePhieuMuon) {
        NodePhieuMuon tg = head;
        NodePhieuMuon t = tg;
        while (tg != null) {
            if (tg == nodePhieuMuon) {
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
        PhieuMuon tmp;
        String loai1;
        String loai2;
        if (head == null) return;
        NodePhieuMuon tg = head, p;
        while (tg.getNext() != null) {
            p = tg.getNext();
            loai1 = tg.getInfo().getmaNguoiMuon().split(" ")[tg.getInfo().getmaNguoiMuon().split(" ").length - 1];
            while (p != null) {
                loai2 = p.getInfo().getmaNguoiMuon().split(" ")[p.getInfo().getmaNguoiMuon().split(" ").length - 1];
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



    public class NodePhieuMuon {
        private PhieuMuon info;
        private NodePhieuMuon next;

        public NodePhieuMuon() {
            this.info = new PhieuMuon();
            next = null;
        }

        public NodePhieuMuon(PhieuMuon info) {
            this.info = info;
        }

        public PhieuMuon getInfo() {
            return info;
        }

        public void setInfo(PhieuMuon info) {
            this.info = info;
        }

        public NodePhieuMuon getNext() {
            return next;
        }

        public void setNext(NodePhieuMuon next) {
            this.next = next;
        }
    }

}
