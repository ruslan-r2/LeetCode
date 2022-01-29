/*
    Вам даны два непустых связанных списка, представляющих два неотрицательных целых числа.
    Цифры хранятся в обратном порядке, и каждый из их узлов содержит одну цифру. Сложите два числа и верните
    сумму в виде связанного списка.
    Вы можете предположить, что эти два числа не содержат никакого начального нуля, кроме самого числа 0.

    Example 1:
    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.

    Example 2:
    Input: l1 = [0], l2 = [0]
    Output: [0]

    Example 3:
    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]

    Ограничения:

    Количество узлов в каждом связанном списке находится в диапазоне [1, 100].
    0 <= Узел.значение <= 9
    Гарантируется, что список представляет собой число, в котором нет начальных нулей.
 */

import models.ListNode;

class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode n4 = new ListNode(3, null);
        ListNode n3 = new ListNode(2, n4);
        ListNode n2 = new ListNode(0, n3);
        ListNode n1 = new ListNode(9, n2);

        ListNode nn3 = new ListNode(4, null);
        ListNode nn2 = new ListNode(6, nn3);
        ListNode nn1 = new ListNode(5, nn2);

        ListNode tmp = addTwoNumbers(n1, nn1);

        do {
            System.out.println( tmp.getVal() );
            tmp = tmp.getNext();
        } while (tmp != null);

    }

    static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode tmp = null;

        int perenos = 0;

        while ( l1 != null || l2 != null ) {
            int summa = perenos;
            if (l1 != null) {
                summa += l1.getVal();
                l1 = l1.getNext();
            }
            if (l2 != null ) {
                summa += l2.getVal();
                l2 = l2.getNext();
            }
            ListNode node = new ListNode(summa % 10);
            perenos = summa / 10;
            if (tmp == null) {
                tmp = head = node;
            } else {
                tmp.setNext(node);
                tmp = tmp.getNext();
            }
        }
        if (perenos > 0) {
            tmp.setNext(new ListNode(perenos));
        }
        return head;
    }
}

