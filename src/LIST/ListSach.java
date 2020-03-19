package LIST;
import MUONSACH.Sach;

public class ListSach {
    NodeSach head, tail;

    public ListSach() {
        this.head = null;
        this.tail = null;
    }

    public NodeSach getHead() {
        return head;
    }

    public NodeSach getTail() {
        return tail;
    }

    public void insertHead(Sach sach) {
        NodeSach newNode = new NodeSach(sach);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.setNext(head); // Gán newNode vào đầu danh sách.
            head = newNode;           // cập nhật lại vị trí đầu của danh sách.
        }
    }

    public void insertTail(Sach sach) {
        NodeSach newNode = new NodeSach(sach);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);      // Gán newNode vào cuối danh sách.
            tail = newNode;               // Cập nhật lại vị trí cuối của danh sách.
        }
    }


    public void removeNode(NodeSach nodeSach) {
        NodeSach tg = head;
        NodeSach t = tg;
        while (tg != null) {
            if (tg == nodeSach) {
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
        Sach tmp;
        String ten1;
        String ten2;
        if (head == null) return;
        NodeSach tg = head, p;
        while (tg.getNext() != null) {
            p = tg.getNext();
            ten1 = tg.getInfo().getTenSach().split(" ")[tg.getInfo().getTenSach().split(" ").length - 1];
            while (p != null) {
                ten2 = p.getInfo().getTenSach().split(" ")[p.getInfo().getTenSach().split(" ").length - 1];
                if (ten1.compareToIgnoreCase(ten2) > 0) {
                    ten1 = ten2;
                    tmp = tg.getInfo();
                    tg.setInfo(p.getInfo());
                    p.setInfo(tmp);
                }
                p = p.getNext();
            }
            tg = tg.getNext();
        }
    }

    public class NodeSach {

        private Sach info;
        private NodeSach next;

        public NodeSach() {
            this.info = new Sach();
            next = null;
        }

        public NodeSach(Sach info) {
            this.info = info;
        }

        public Sach getInfo() {
            return info;
        }

        public void setInfo(Sach info) {
            this.info = info;
        }

        public NodeSach getNext() {
            return next;
        }

        public void setNext(NodeSach next) {
            this.next = next;
        }
    }

}
