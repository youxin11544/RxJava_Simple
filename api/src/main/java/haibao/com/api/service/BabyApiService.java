package haibao.com.api.service;

import java.util.List;

import haibao.com.api.data.param.baby.AddBabyParams;
import haibao.com.api.data.param.baby.AnswerQuestionNaireParams;
import haibao.com.api.data.param.baby.ModifyBabyInfoParams;
import haibao.com.api.data.response.baby.Baby;
import haibao.com.api.data.response.baby.PostBabiesAvatarsResponse;
import haibao.com.api.data.response.baby.QuestionNaire;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * groupTitle= 宝宝信息  
 * groupDescription=<p>宝宝信息相关</p>  
 */
//@ApiFactory(
//    packageName = "haibao.com.api"
//)
public interface BabyApiService {


  /**
   * title=  获取所有宝宝信息
   * version=1.1.0
   * api url = <a href="https://hbapidev.baobaobooks.net/docs/user/#api-babyGroup-get_babies">获取所有宝宝信息</>
   */
  @GET("babies")
  Observable<List<Baby>> GetBabies();


  /**
   * title= 获取单个宝宝信息
   * version= 1.1.0
   * api url = <a href="https://hbapidev.baobaobooks.net/docs/user/#api-babyGroup-get_babies__baby_id">获取单个宝宝信息</>
   */
  @GET("babies/{baby_id}")
  Observable<Baby> GetBabyInfo(@Path("baby_id") final String baby_id);

  /**
   * title= 添加宝宝
   * version=1.0.0
   * api url = <a href="https://hbapidev.baobaobooks.net/docs/user/#api-babyGroup-post_babies">添加宝宝</>
   */
  @POST("babies")
  Observable<Baby> addBaby(@Body AddBabyParams params);

  /**
   * title= 修改宝宝信息
   * version=1.0.0
   * api url = <a href="https://hbapidev.baobaobooks.net/docs/user/#api-babyGroup-put_babies__baby_id">修改宝宝信息</>
   */
  @PUT("babies/{baby_id}")
  Observable<Baby> modifyBabyInfo(@Path("baby_id") final String baby_id, @Body ModifyBabyInfoParams params);

  /**
   * title= 删除宝宝
   * version=1.0.0
   * api url = <a href="https://hbapidev.baobaobooks.net/docs/user/#api-babyGroup-delete_babies__baby_id">删除宝宝</>
   */
  @DELETE("babies/{baby_id}")
  Observable<Void> DeleteBabiesBabyId(@Path("baby_id") final String baby_id);


  /**
   * title= 上传宝宝头像
   * version=1.0.0
   * api url = <a href="https://hbapidev.baobaobooks.net/docs/user/#api-babyGroup-post_babies_avatars">上传宝宝头像</>
   */
  @POST("babies/avatars")
  Observable<PostBabiesAvatarsResponse> PostBabiesAvatars(@Body MultipartBody multipartBody);


  /**
   * title= 宝宝信息 - 获取问卷
   * version=1.0.0
   * api url = <a href="https://hbapidev.baobaobooks.net/docs/user/#api-babyGroup-get_babies_questionnaire">获取问卷</>
   */
  @GET("babies/questionnaire")
  Observable<QuestionNaire> GetBabiesQuestionnaire(@Query("birthday") String birthday);


  /**
   * title= 宝宝信息 - 回答问卷
   * version=1.0.0
   * api url = <a href="https://hbapidev.baobaobooks.net/docs/user/#api-babyGroup-put_babies_questionnaire__qst_key">回答问卷</>
   */
  @PUT("babies/questionnaire/{qst_key}")
  Observable<QuestionNaire> PutBabiesQuestionnaireQstKey(@Path("qst_key") String qst_key, @Query("birthday") String birthday,
                                                         @Body AnswerQuestionNaireParams params);

}
