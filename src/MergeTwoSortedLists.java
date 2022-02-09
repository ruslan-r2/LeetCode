/*
    Даны указатели двух отсортированных связанных списков l1 и l2.

    Выполните слияние двух списков в один отсортированный список. Список должен быть составлен
    путем соединения вместе узлов из первых двух списков.

    Верните указатель объединенного связанного списка.

    Пример 1:
      Дано: list1 = [1,2,4], list2 = [1,3,4]
      Вывод: [1,1,2,3,4,4]

    Пример 2:
      Дано: list1 = [], list2 = []
      Вывод: []

    Пример 3:
      Дано: list1 = [], list2 = [0]
      Вывод: [0]
 */

import models.ListNode;

public class MergeTwoSortedLists {

    public static void main(String[] args) {


        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(3,l23);
        ListNode l21 = new ListNode(1,l22);

        ListNode l13 = new ListNode(4);
        ListNode l12 = new ListNode(2, l13);
        ListNode l11 = new ListNode(1, l12);

        ListShow( mergeTwoLists(l11, l21) );

    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Проверяем не является ли какой-либо из списков пустым
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // Первый элемент нового списка
        ListNode head;
        // Указатель текущего элемента в новом списке
        ListNode pointer;
        // Выбираем первый наименьший элемент из двух списков
        if (l1.getVal() < l2.getVal()) {
            pointer = head = new ListNode(l1.getVal());
            l1 = l1.getNext();
        } else {
            pointer = head = new ListNode(l2.getVal());
            l2 = l2.getNext();
        }
        // Добаляем элементы в цыкле, пока один из списков не закончится.
        while (l1 != null && l2 != null) {
            if (l1.getVal() < l2.getVal()) {
                pointer.setNext( new ListNode(l1.getVal()) );
                l1 = l1.getNext();
            } else {
                pointer.setNext( new ListNode(l2.getVal()));
                l2 = l2.getNext();
            }
            pointer = pointer.getNext();
        }
        // Добавьте все узлы из l1, если они остались
        while (l1 != null) {
            pointer.setNext( new ListNode(l1.getVal()) );
            l1 = l1.getNext();
            pointer = pointer.getNext();
        }
        // Добавьте все узлы из l2, если они остались
        while (l2 != null) {
            pointer.setNext( new ListNode(l2.getVal()) );
            l2 = l2.getNext();
            pointer = pointer.getNext();
        }
        return head;
    }

    public static void ListShow(ListNode head) {
        while (head != null) {
            System.out.print(" > " + head.getVal() );
            head = head.getNext();
        }
    }

}