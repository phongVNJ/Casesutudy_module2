package LIST;
import MUONSACH.DauSach;
public class ListDauSach {
    private NodeDauSach head, tail;

    public ListDauSach() {
        this.head = null;
        this.tail = null;
    }

    public NodeDauSach getHead() {
        return head;
    }

    public NodeDauSach getTail() {
        return tail;
    }

    public void insertHead(DauSach dauSach) {
        NodeDauSach newNode = new NodeDauSach(dauSach);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.setNext(head); // Gán newNode vào đầu danh sách.
            head = newNode;           // cập nhật lại vị trí đầu của danh sách.
        }
    }

    public void insertTail(DauSach dauSach) {
        NodeDauSach newNode = new NodeDauSach(dauSach);
        if (head == null) head = tail = newNode;
        else {
            tail.setNext(newNode);      // Gán newNode vào cuối danh sách.
            tail = newNode;               // Cập nhật lại vị trí cuối của danh sách.
        }
    }

    public void deleteNode(NodeDauSach nodeDauSach) {
        NodeDauSach tg = head;
        NodeDauSach t = tg;
        while (tg != null) {
            if (tg == nodeDauSach) break;
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

    public void removeNode(NodeDauSach nodeDauSach) {
        NodeDauSach tg = head;
        NodeDauSach t = tg;
        while (tg != null) {
            if (tg == nodeDauSach) {
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
        DauSach tmp;
        String loai1;
        String loai2;
        if (head == null) return;
        NodeDauSach tg = head, p;
        while (tg.getNext() != null) {
            p = tg.getNext();
            loai1 = tg.getInfo().getTenSach().split(" ")[tg.getInfo().getTenSach().split(" ").length - 1];
            while (p != null) {
                loai2 = p.getInfo().getTenSach().split(" ")[p.getInfo().getTenSach().split(" ").length - 1];
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


    public class NodeDauSach {
        private DauSach info;
        private NodeDauSach next;

        public NodeDauSach() {
            this.info = new DauSach();
            next = null;
        }

        public NodeDauSach(DauSach info) {
            this.info = info;
        }

        public DauSach getInfo() {
            return info;
        }

        public void setInfo(DauSach info) {
            this.info = info;
        }

        public NodeDauSach getNext() {
            return next;
        }

        public void setNext(NodeDauSach next) {
            this.next = next;
        }
    }

}
