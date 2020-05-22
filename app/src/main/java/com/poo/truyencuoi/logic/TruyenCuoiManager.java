package com.poo.truyencuoi.logic;

import java.util.ArrayList;
import java.util.List;

public class TruyenCuoiManager {
    public static final String[] NAME_STORY_VN = new String[]{"Con gái", "Công sở",
            "Con nít", "Con trai", "Cực hài",
            "Cười 18", "Dân gian", "Gia đình", "Giao thông", "Học sinh", "Hội chợ cười",
            "Khoa học", "Nghề nghiệp", "Người lớn", "Nhà hàng", "Say xỉn", "Tam quốc", "Tây du kí chế"
            , "Thế giới", "Thơ ca cười", "Thơ vui", "Tiếu lâm", "Tình yêu", "Tôn giáo", "Trạng Quỳnh", "Truyện bựa",
            "Việt nam và thế giới", "Vova", "Y tế"};
    public static final String[] FILE_STORY_VN = new String[]{"congai", "congso", "connit", "contrai", "cuchai", "cuoi18", "dangian", "giadinh", "giaothong", "hocsinh", "hoichocuoi", "khoahoc", "nghenghiep", "nguoilon", "nhahang", "sayxin", "tamquoc", "taydukiche", "thegioi", "thocacuoi", "thovui", "tieulam", "tinhyeu", "tongiao", "trangquynh", "truyenbua", "vnvathegioi", "vova", "yte"};


    public static final String[] NAME_STORY_ENG = new String[]{"Animals", "Blone",
            "Dirty", "International", "Kids", "School", "Sport", "Workplace", "Yo mama"};
    public static final String[] FILE_STORY_ENGLISH = new String[]{"animals", "blone",
            "dirty", "international", "kids", "school", "sport", "workplace", "yo-mama"};
    private List<Tittle> listChuDeTruyenVN, listChuDeTruyenEN;

    public TruyenCuoiManager() {
        this.listChuDeTruyenVN = new ArrayList<>();
        this.listChuDeTruyenEN = new ArrayList<>();
        for (int i = 0; i < NAME_STORY_VN.length; i++) {
            listChuDeTruyenVN.add(new Tittle(NAME_STORY_VN[i], "data/vn/" + FILE_STORY_VN[i] + ".txt", "icon/vn/" + FILE_STORY_VN[i] + ".png"));
        }
        for (int i = 0; i < NAME_STORY_ENG.length; i++) {
            listChuDeTruyenEN.add(new Tittle(NAME_STORY_ENG[i], "data/en/" + FILE_STORY_ENGLISH[i] + ".txt", "icon/en/" + FILE_STORY_ENGLISH[i] + ".png"));
        }
    }

    public List<Tittle> getListChuDeTruyenVN() {
        return listChuDeTruyenVN;
    }

    public List<Tittle> getListChuDeTruyenEN() {
        return listChuDeTruyenEN;
    }
}
