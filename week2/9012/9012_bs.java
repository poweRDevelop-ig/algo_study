/*
이전에 StringBuilder에 A-Z가 나오면 append를 해줘 저장하고 그 후 닫는 괄호나 * , / 가 나오면 그 때 스택에서 StringBuilder에
추가해주는 형식으로 진행하였다.
그렇게 하여 예시와 똑같은 답이 나왔으나 결과는 틀렸다고 한다.
여기서 문제에서 놓친 부분은

예를 들어 a+b*c는 (a+(b*c))의 식과 같게 된다. 그 다음에 안에 있는 괄호의 연산자 *를 괄호 밖으로 꺼내게 되면 (a+bc*)가 된다.
마지막으로 또 +를 괄호의 오른쪽으로 고치면 abc*+가 되게 된다.

이 부분이 없어 문제가 틀렸다고 추측을 하기 시작했다.

 */