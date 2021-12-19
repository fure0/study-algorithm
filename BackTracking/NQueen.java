import java.util.ArrayList;

public class NQueen {

    public boolean isAvailable(ArrayList<Integer> candidate, Integer currentCol) { // 후보와
        Integer currentRow = candidate.size(); // 후보군에 들어가 있는 사이즈 + 1이 다음 행(row)을 체크하니까
        System.out.println("");
        System.out.println("@candidate : " + candidate);
        System.out.println("currentRow : " + currentRow + ", currentCol : " + currentCol);
        for (int index = 0; index < currentRow; index++) { //3행 후보값을 확인중이면 1~2행을 순회해 봐야 하니까
            //수평조건 체크 퀸의 위치 == 현재 행인지 확인) candidate는 퀸 후보 위치가 되기 때문에 같은 열(col) 인지 확인하는 과정
            //대각선 체크 절대값(abs)(퀸의 열 - 현재열 = 1)) == (핸재행 - 퀸의행 = 1)
            if ((candidate.get(index) == currentCol) || (Math.abs(candidate.get(index) - currentCol) == currentRow - index) ) {
                System.out.println("return false");
                return false;
            }
        }
        System.out.println("return true");
        return true;
    }
    
    public void dfsFunc(Integer N, Integer currentRow, ArrayList<Integer> currentCandidate) {
        if (currentRow == N) { // 여기까지 온거면 전체 다 확인한거라 더 진행 할 필요가 없다
            System.out.println(currentCandidate);
            return ;
        }
        
        for (int col = 0; col < N; col++) { // 0 ~ 4 열 까지 
            if (this.isAvailable(currentCandidate, col) == true) { // 다른 퀸의 이동 범위에 침범하지 않으면
                currentCandidate.add(col); //현재 행의 해당열(세로:col)을 후보군에 넣는다
                System.out.println("currentCandidate : " + currentCandidate);
                this.dfsFunc(N, currentRow + 1, currentCandidate); //다음행(가로:row) 확인 하기위해 +1
                currentCandidate.remove(currentCandidate.size() - 1); //여기를 통과한다면 해당 후보군은 사용할수 없기 때문에 현재 행의 해당열을 가지치기(제외)한다.
            }
        }
    }   
    
    public static void main(String[] args) {

        NQueen nObject = new NQueen();
        nObject.dfsFunc(4, 0, new ArrayList<Integer>()); // 4x4의 크기, 0행(가로:row) 부터 시작(행은 볼 필요가 없음), 처음엔 빈 리스트 입력

    }
}
