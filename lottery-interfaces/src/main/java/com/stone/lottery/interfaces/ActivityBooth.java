package com.stone.lottery.interfaces;

import com.stone.lottery.common.Constants;
import com.stone.lottery.common.Result;
import com.stone.lottery.infrastructure.dao.IActivityDao;
import com.stone.lottery.infrastructure.po.Activity;
import com.stone.lottery.rpc.IActivityBooth;
import com.stone.lottery.rpc.dto.ActivityDto;
import com.stone.lottery.rpc.req.ActivityReq;
import com.stone.lottery.rpc.res.ActivityRes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 活动展台
 */
@Service
public class ActivityBooth implements IActivityBooth {

    @Resource
    private IActivityDao activityDao;

    @Override
    public ActivityRes queryActivityById(ActivityReq req) {

        Activity activity = activityDao.queryActivityById(req.getActivityId());

        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityId(activity.getActivityId());
        activityDto.setActivityName(activity.getActivityName());
        activityDto.setActivityDesc(activity.getActivityDesc());
        activityDto.setBeginDateTime(activity.getBeginDateTime());
        activityDto.setEndDateTime(activity.getEndDateTime());
        activityDto.setStockCount(activity.getStockCount());
        activityDto.setTakeCount(activity.getTakeCount());

        return new ActivityRes(new Result(Constants.ResponseCode.SUCCESS.getCode(),
                Constants.ResponseCode.SUCCESS.getInfo()), activityDto);
    }
}
