## 정렬시 참고 사항 ( Array.sort vs Collection.sort )



Arrays.sort()는 Dual-Pivot Quicksort를 사용합니다.

Collections.sort()는 merge sort와 insert sort를 합친 timsort를 사용합니다.

**Quick sort는 배열에서 좋은 성능을 보이지만 stable(안정적)하지 않아서 stable이 필요한 Object에는 Collections.sort()가 많이 쓰입니다.**

[**https://stackoverflow.com/questions/32334319/why-does-collections-sort-use-mergesort-but-arrays-sort-does-not**](https://stackoverflow.com/questions/32334319/why-does-collections-sort-use-mergesort-but-arrays-sort-does-not)

**출처 :** [**https://velog.io/@sparkbosing/Java-Arrays.sort%EC%99%80-Collections.sort%EC%9D%98-%EC%B0%A8%EC%9D%B4**](https://velog.io/@sparkbosing/Java-Arrays.sort와-Collections.sort의-차이)

****



두번째로는 Counting 알고리즘을 많이 쓰는게 좋다.

