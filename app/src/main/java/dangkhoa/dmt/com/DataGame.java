package dangkhoa.dmt.com;

import android.content.Context;

import java.util.ArrayList;
import java.util.Random;

public class DataGame{

    int[][] mangHaiChieu = new int[4][4];
    int[][] _loai = new int[4][4];


    private ArrayList<Integer> arrSo = new ArrayList<>();
    private ArrayList<Integer> Loai = new ArrayList<>();

    public ArrayList<Integer> getArrSo() {
        return arrSo;
    }
    public ArrayList<Integer> getLoai()
    {
        return Loai;
    }

    private static DataGame datagame;
    static {
        datagame = new DataGame();
    }
    public static DataGame getDatagame(){
        return datagame;
    }

    private Random r = new Random();

    public void intt(Context context){
        for(int i = 0;i< 4; i++)
        {
            for(int j = 0;j < 4;j++)
            {
                mangHaiChieu[i][j] = 0;
                _loai[i][j] = 0;
                arrSo.add(0);
                Loai.add(0);
            }
        }

        taoSo();
        chuyenDoi();
    }



    public void taoSo()
    {
        int so_0 = 0;
        for(int i = 0;i < 16;i++)
        {
            if(arrSo.get(i) == 0)
            {
                so_0++;
            }
        }
        int so_0_Tao;
        if(so_0 == 16)
        {
            so_0_Tao = 2;
        }
        else
        {
            if (so_0 > 0)
            {
                so_0_Tao = 1;
            }
            else
            {
                so_0_Tao = 0;
            }
        }


        while(so_0_Tao != 0)
        {
            int i = r.nextInt(4);
            int j = r.nextInt(4);
            if(mangHaiChieu[i][j] == 0)
            {
                mangHaiChieu[i][j] = 2 + r.nextInt(2)*2;
                _loai[i][j] = 2;
                so_0_Tao--;
            }
        }
    }
    public void chuyenDoi()
    {
        arrSo.clear();
        Loai.clear();
        for(int i = 0;i < 4;i++)
        {
            for(int j = 0;j < 4;j++)
            {
                arrSo.add(mangHaiChieu[i][j]);
                Loai.add(_loai[i][j]);
            }
        }
    }
    public void restart()
    {
        arrSo.clear();
        Loai.clear();
        for(int i = 0;i < 4;i++)
        {
            for(int j = 0;j < 4;j++)
            {
                mangHaiChieu[i][j] = 0;
                _loai[i][j] = 0;
                arrSo.add(0);
                Loai.add(0);
            }
        }
        taoSo();
        chuyenDoi();
    }

    public void resetLoai()
    {
        Loai.clear();
        for(int i = 0;i < 4;i++)
        {
            for(int j = 0;j < 4;j++)
            {
                _loai[i][j] = 0;
            }
        }
    }


    // Vuốt trái
    public void vuotTrai()
    {
        for(int i = 0;i < 4;i++)
        {
            for(int j = 0;j < 4;j++)
            {
                int so = mangHaiChieu[i][j];
                if(so == 0)
                {
                    continue;
                }
                else
                {
                    for(int k = j + 1;k < 4;k++)
                    {
                        int so_2 = mangHaiChieu[i][k];
                        if(so_2 == 0)
                        {
                            continue;
                        }
                        else
                        {
                            if(so_2 == so)
                            {
                                mangHaiChieu[i][j] = so*2;
                                _loai[i][j] = 1;
                                mangHaiChieu[i][k] = 0;
                                _loai[i][k] = 0;
                                break;
                            }
                            else
                            {
                                break;
                            }
                        }
                    }
                }
            }
        }
        // Sắp xếp
        for(int i = 0;i < 4;i++)
        {
            for(int j = 0;j < 4;j++)
            {
                int so = mangHaiChieu[i][j];
                if(so == 0)
                {
                    for(int k = j + 1;k < 4;k++)
                    {
                        int so_2 = mangHaiChieu[i][k];
                        int loai_2 = _loai[i][k];
                        if(so_2 == 0)
                        {
                            continue;
                        }
                        else
                        {
                            mangHaiChieu[i][j] = so_2;
                            _loai[i][j] = loai_2;
                            mangHaiChieu[i][k] = 0;
                            _loai[i][k] = 0;
                            break;
                        }
                    }
                }
            }
        }
        taoSo();
        chuyenDoi();
    }

    // Vuốt phải
    public void vuotPhai()
    {
        for(int i = 0;i < 4;i++)
        {
            for(int j = 3;j >= 0;j--)
            {
                int so = mangHaiChieu[i][j];
                if(so == 0)
                {
                    continue;
                }
                else
                {
                    for(int k = j - 1;k >= 0;k--)
                    {
                        int so_2 = mangHaiChieu[i][k];
                        if(so_2 == 0)
                        {
                            continue;
                        }
                        else
                        {
                            if(so == so_2)
                            {
                                mangHaiChieu[i][j] = so*2;
                                _loai[i][j] = 1;
                                mangHaiChieu[i][k] = 0;
                                _loai[i][k] = 0;
                                break;
                            }
                            else
                            {
                                break;
                            }
                        }
                    }
                }
            }
        }

        // Sắp xếp
        for(int i = 0;i < 4;i++)
        {
            for(int j = 3;j >= 0;j--)
            {
                int so = mangHaiChieu[i][j];
                if(so == 0)
                {
                    for(int k = j - 1;k >= 0;k--)
                    {
                        int so_2 = mangHaiChieu[i][k];
                        int loai_2 = _loai[i][k];
                        if(so_2 == 0)
                        {
                            continue;
                        }
                        else
                        {
                            mangHaiChieu[i][j] = so_2;
                            _loai[i][j] = loai_2;
                            mangHaiChieu[i][k] = 0;
                            _loai[i][k] = 0;
                            break;
                        }
                    }
                }
            }
        }
        taoSo();
        chuyenDoi();
    }

    // Vuốt lên
    public void vuotLen()
    {
        for(int j = 0;j < 4;j++)
        {
            for(int i = 0;i < 4;i++)
            {
                int so = mangHaiChieu[i][j];
                if(so == 0)
                {
                    continue;
                }
                else
                {
                    for(int k = i + 1;k < 4;k++)
                    {
                        int so_2 = mangHaiChieu[k][j];
                        if(so_2 == 0)
                        {
                            continue;
                        }
                        else
                        {
                            if(so_2 == so)
                            {
                                mangHaiChieu[i][j] = so*2;
                                _loai[i][j] = 1;
                                mangHaiChieu[k][j] = 0;
                                _loai[k][j] = 0;
                                break;
                            }
                            else
                            {
                                break;
                            }
                        }
                    }
                }
            }
        }

        // Sắp xếp
        for(int j = 0;j < 4;j++)
        {
            for(int i = 0;i < 4;i++)
            {
                int so = mangHaiChieu[i][j];
                if(so == 0)
                {
                    for(int k = i + 1;k < 4;k++)
                    {
                        int so_2 = mangHaiChieu[k][j];
                        int loai_2 = _loai[k][j];
                        if(so_2 == 0)
                        {
                            continue;
                        }
                        else
                        {
                            mangHaiChieu[i][j] = so_2;
                            _loai[i][j] = loai_2;
                            mangHaiChieu[k][j] = 0;
                            _loai[k][j] = 0;
                            break;
                        }
                    }
                }
            }
        }
        taoSo();
        chuyenDoi();
    }

    // Vuốt xuống
    public void vuotXuong() {
        for (int j = 0; j < 4; j++) {
            for (int i = 3; i >= 0; i--) {
                int so = mangHaiChieu[i][j];
                if (so == 0) {
                    continue;
                } else {
                    for (int k = i - 1; k >= 0; k--) {
                        int so_2 = mangHaiChieu[k][j];
                        if (so_2 == 0) {
                            continue;
                        } else {
                            if (so_2 == so) {
                                mangHaiChieu[i][j] = so * 2;
                                _loai[i][j] = 1;
                                mangHaiChieu[k][j] = 0;
                                _loai[k][j] = 0;
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }


        // Sắp xếp
        for (int j = 0; j < 4; j++) {
            for (int i = 3; i >= 0; i--) {
                int so = mangHaiChieu[i][j];
                if (so == 0) {
                    for (int k = i - 1; k >= 0; k--) {
                        int so_2 = mangHaiChieu[k][j];
                        int loai_2 = _loai[k][j];
                        if (so_2 == 0) {
                            continue;
                        } else {
                            mangHaiChieu[i][j] = so_2;
                            _loai[i][j] = loai_2;
                            mangHaiChieu[k][j] = 0;
                            _loai[k][j] = 0;
                            break;
                        }
                    }
                }
            }
        }
        taoSo();
        chuyenDoi();
    }

    public int kiemTra()
    {
        for(int i = 0;i < 4;i++)
        {
            for(int j = 0;j < 4;j++)
            {
                if(mangHaiChieu[i][j] == 0)
                {
                    return 1;
                }
            }
        }
        if(mangHaiChieu[0][0] == mangHaiChieu[0][1] || mangHaiChieu[0][0] == mangHaiChieu[1][0])
        {
            return 1;
        }
        if(mangHaiChieu[3][0] == mangHaiChieu[3][1] || mangHaiChieu[3][0] == mangHaiChieu[2][0])
        {
            return 1;
        }
        if(mangHaiChieu[3][3] == mangHaiChieu[3][2] || mangHaiChieu[3][3] == mangHaiChieu[2][3])
        {
            return 1;
        }
        if(mangHaiChieu[0][3] == mangHaiChieu[0][2] || mangHaiChieu[0][3] == mangHaiChieu[1][3])
        {
            return 1;
        }
        for(int j = 1;j < 3;j++)
        {
            if(mangHaiChieu[0][j] == mangHaiChieu[0][j-1] || mangHaiChieu[0][j] == mangHaiChieu[0][j+1] || mangHaiChieu[0][j] == mangHaiChieu[1][j])
            {
                return 1;
            }
            if(mangHaiChieu[3][j] == mangHaiChieu[3][j-1] || mangHaiChieu[3][j] == mangHaiChieu[3][j+1] || mangHaiChieu[3][j] == mangHaiChieu[2][j])
            {
                return 1;
            }
        }
        for(int i = 1;i < 3;i++)
        {
            if(mangHaiChieu[i][0] == mangHaiChieu[i - 1][0] || mangHaiChieu[i][0] == mangHaiChieu[i+1][0] || mangHaiChieu[i][0] == mangHaiChieu[i][1])
            {
                return 1;
            }
            if(mangHaiChieu[i][3] == mangHaiChieu[i - 1][3] || mangHaiChieu[i][3] == mangHaiChieu[i+1][3] || mangHaiChieu[i][3] == mangHaiChieu[i][2])
            {
                return 1;
            }
        }
        for(int i = 1;i < 3;i++)
        {
            for(int j = 1;j < 3;j++)
            {
                if(mangHaiChieu[i][j] == mangHaiChieu[i - 1][j] || mangHaiChieu[i][j] == mangHaiChieu[i + 1][j] || mangHaiChieu[i][j] == mangHaiChieu[i][j - 1] || mangHaiChieu[i][j] == mangHaiChieu[i][j + 1])
                    return 1;
            }
        }
        return 0;
    }
}




