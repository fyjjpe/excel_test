package excel;

import db.DBhelper;
import entity.StuEntity;
import service.StuService;

import java.util.List;

/**
 * Created by Administrator on 2017/5/14.
 * Excel表中的数据导入到MySql数据库
 */
public class TestExcelToDb {
    public static void main(String[] args) {
        //得到表格中所有的数据
        List<StuEntity> listExcel = StuService.getAllByExcel("d://book.xls");
        /*//得到数据库表中所有的数据
        List<StuEntity> listDb=StuService.getAllByDb();*/
        try{
            DBhelper db = new DBhelper();

            for (StuEntity stuEntity : listExcel) {
                int id = stuEntity.getId();
                if (!StuService.isExist(id)) {
                    //不存在就添加
                    String sql = "insert into stu (id,name,sex,num) values(?,?,?,?)";
                    String[] str = new String[]{id + "",stuEntity.getName(), stuEntity.getSex(), stuEntity.getNum() + ""};
                    db.AddU(sql, str);
                } else {
                    //存在就更新
                    String sql = "update stu set name=?,sex=?,num=? where id=?";
                    String[] str = new String[]{stuEntity.getName(), stuEntity.getSex(), stuEntity.getNum() + "", id + ""};
                    db.AddU(sql, str);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
