package umc.week7.service.TempService;

import umc.week7.apiPayload.code.status.ErrorStatus;
import umc.week7.apiPayload.exception.handler.TempHandler;

public class TempQueryServiceImpl implements TempQueryService {

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);

    }
}
