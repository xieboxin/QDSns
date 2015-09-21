package com.qurdao.qdsns.app.bean;

import com.qurdao.qdsns.R;
import com.qurdao.qdsns.app.fragment.mission.AllFragment;
import com.qurdao.qdsns.app.fragment.mission.BranchFragment;
import com.qurdao.qdsns.app.fragment.mission.CopyFragment;
import com.qurdao.qdsns.app.fragment.mission.DailyFragment;
import com.qurdao.qdsns.app.fragment.mission.GuildFragment;
import com.qurdao.qdsns.app.fragment.mission.TrunkFragment;

/**
 * Created by xiex on 2015/8/17.
 */
public enum MssionTab {

    ALL("10", R.string.mission_all, R.drawable.tab_mission_all_btn,
            AllFragment.class),
    DAILY("20", R.string.mission_daily, R.drawable.tab_mission_daily_btn,
            DailyFragment.class),
    GUILD("30", R.string.mission_guild, R.drawable.tab_mission_guild_btn,
            GuildFragment.class),
    TRUNK("40", R.string.mission_trunk, R.drawable.tab_mission_trunk_btn,
            TrunkFragment.class),
    BRANCH("50", R.string.mission_branch, R.drawable.tab_mission_branch_btn,
            BranchFragment.class),
    COPY("60", R.string.mission_copy, R.drawable.tab_mission_copy_btn,
            CopyFragment.class);

    private String idx;
    private int resName;
    private int resIcon;
    private Class<?> clz;

    private MssionTab(String idx, int resName, int resIcon, Class<?> clz) {
        this.idx = idx;
        this.resName = resName;
        this.resIcon = resIcon;
        this.clz = clz;
    }

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    public int getResName() {
        return resName;
    }

    public void setResName(int resName) {
        this.resName = resName;
    }

    public int getResIcon() {
        return resIcon;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }

    public Class<?> getClz() {
        return clz;
    }

    public void setClz(Class<?> clz) {
        this.clz = clz;
    }
}
