package haibao.com.api.service;

import java.util.List;

import haibao.com.api.BaseApi;
import haibao.com.api.BaseApi.ClearWrapper;
import haibao.com.api.common.CommonUrl;
import haibao.com.api.data.param.baby.AddBabyParams;
import haibao.com.api.data.param.baby.AnswerQuestionNaireParams;
import haibao.com.api.data.param.baby.ModifyBabyInfoParams;
import haibao.com.api.data.response.baby.Baby;
import haibao.com.api.data.response.baby.PostBabiesAvatarsResponse;
import haibao.com.api.data.response.baby.QuestionNaire;
import okhttp3.MultipartBody;
import rx.Observable;

/**
 * @ API包装类 此类由apt自动生成 */
public final class BabyApiApiWrapper implements ClearWrapper {
  private static BabyApiApiWrapper INSTANCE;

  private static BabyApiService BabyApiService;

  public static BabyApiApiWrapper getInstance() {
    if (INSTANCE==null) {
      INSTANCE=new BabyApiApiWrapper();
      BaseApi.addToBaseApi(INSTANCE);
    }
    return INSTANCE;
  }

  public BabyApiService getBabyApiService() {
    if (BabyApiService==null) {
      BabyApiService=BaseApi.getRetrofit(CommonUrl.BabyApiService_BaseUrl).create(BabyApiService.class);
    }
    return BabyApiService;
  }

  public void clearService() {
    BabyApiService=null;
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> DeleteBabiesBabyId(String baby_id) {
    return getBabyApiService().DeleteBabiesBabyId(baby_id).compose(BaseApi.<Void>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<List<Baby>> GetBabies() {
    return getBabyApiService().GetBabies().compose(BaseApi.<List<Baby>>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Baby> GetBabyInfo(String baby_id) {
    return getBabyApiService().GetBabyInfo(baby_id).compose(BaseApi.<Baby>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Baby> addBaby(AddBabyParams params) {
    return getBabyApiService().addBaby(params).compose(BaseApi.<Baby>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<PostBabiesAvatarsResponse> PostBabiesAvatars(MultipartBody multipartBody) {
    return getBabyApiService().PostBabiesAvatars(multipartBody).compose(BaseApi.<PostBabiesAvatarsResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Baby> modifyBabyInfo(String baby_id, ModifyBabyInfoParams params) {
    return getBabyApiService().modifyBabyInfo(baby_id,params).compose(BaseApi.<Baby>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<QuestionNaire> GetBabiesQuestionnaire(String birthday) {
    return getBabyApiService().GetBabiesQuestionnaire(birthday).compose(BaseApi.<QuestionNaire>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<QuestionNaire> PutBabiesQuestionnaireQstKey(String qst_key, String birthday,
      AnswerQuestionNaireParams params) {
    return getBabyApiService().PutBabiesQuestionnaireQstKey(qst_key,birthday,params).compose(BaseApi.<QuestionNaire>defaultSchedulers());
  }
}
