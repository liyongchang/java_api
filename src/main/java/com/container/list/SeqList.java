package com.container.list;

public class SeqList<T> {
    Node head;

    static SeqList creat(int n) {
        SeqList a = new SeqList();
        Node temp = a.head;
        for (int i = 0; i < n; i++) {
            Node addNode = new Node();
            addNode.data = (i + 1000);
            if (i == 0) {
                temp = addNode;
                a.head = (temp);
                continue;
            }
            addNode.data = (i + 1000);
            temp.next = addNode;
            temp = temp.next;
        }
        return a;
    }

    public static void main(String[] args) {
        /*SeqList seqList = creat(4);
        printSeq(seqList);
        //seqList.addFirst(seqList, 1000);
        //addLast(seqList, 4000);
        System.out.println("反转前");
        SeqList seqList1 = reverse(seqList);
        printSeq(seqList1);


        CopyOnWriteArrayList copyOnWriteArrayList=new CopyOnWriteArrayList();*/
        ListNode node=new ListNode();
        node.val=1;
        ListNode node1=new ListNode();
        node1.val=2;
        node.next=node1;


        reverseList(node);




    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        ListNode nextP = null;
        while (cur != null) {
            nextP = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextP;
        }
        return pre;
    }

    private static SeqList reverse(SeqList head) {
        Node pre = head.head;
        Node cur = pre.next;
        Node temp;
        pre.next = (null);
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        head.head = (pre);
        return head;
    }

    private void addFirst(SeqList seqList, int i) {
        Node addNode = new Node();
        addNode.data = (i + 1000);
        Node head = seqList.head;
        seqList.head = (addNode);
        addNode.next = (head);
        printSeq(seqList);
    }

    private static void addLast(SeqList seqList, int i) {
        Node addNode = new Node();
        addNode.data = (i + 1000);
        addNode.next = (null);
        Node head = seqList.head;
        while (head.next != null) {
            head = head.next;
        }
        head.next = addNode;
    }

    private static void printSeq(SeqList seqList) {
        if (seqList.head == null) {
            System.out.println("null");
            return;
        }
        Node node = seqList.head;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }
}
