import java.util.ArrayList;

public class NQueen {

    public boolean isAvailable(ArrayList<Integer> candidate, Integer currentCol) {
        Integer currentRow = candidate.size();
        for (int index = 0; index < currentRow; index++) {
            if ((candidate.get(index) == currentCol) || (Math.abs(candidate.get(index) - currentCol) == currentRow - index) ) {
                return false;
            }
        }
        return true;
    }
    
    public void dfsFunc(Integer N, Integer currentRow, ArrayList<Integer> currentCandidate) {
        if (currentRow == N) { // 여기까지 온거면 전체 다 확인한거라 더 진행 할 필요가 없다
            System.out.println(currentCandidate);
            return ;
        }
        
        for (int index = 0; index < N; index++) { // 0 ~ 4 까지 
            if (this.isAvailable(currentCandidate, index) == true) { // 다른 퀸의 이동 범위에 침범하지 않으면
                currentCandidate.add(index);
                this.dfsFunc(N, currentRow + 1, currentCandidate); //다음열 확인 하기위해 +1
                currentCandidate.remove(currentCandidate.size() - 1); //여기를 통과한다면 후보군이 없기 때문에 해당 행 자체를 가지치기한다.
            }
        }
    }   
    
    public static void main(String[] args) {

        NQueen nObject = new NQueen();
        nObject.dfsFunc(4, 0, new ArrayList<Integer>()); // 4x4의 크기, 0열 부터 시작(행은 볼 필요가 없음), 처음엔 빈 리스트 입력

    }
}
