package haibao.com.api.service;


import haibao.com.api.data.response.company.CompanyInfoResponse;
import haibao.com.api.data.response.company.GetLectureResponse;
import haibao.com.api.data.response.company.GetQaTalkResponse;
import retrofit2.http.GET;
import rx.Observable;

/**
 * API接口方法申明接口类
 *
 * 陪伴
 *
 */
//@ApiFactory(
//        packageName = "haibao.com.api"
//)
public interface CompanyService {
    /**
     * title=获取陪伴信息
     * version = 1.1.0
     * api url= https://hbapidev.baobaobooks.net/docs/company/#api-companyGroup-get_company
     */
    @GET("company")
    Observable<CompanyInfoResponse> getAccmpanyInfo();
    /**
     * title= 获取QA谈信息
     * version = 1.1.0
     * api url= https://hbapidev.baobaobooks.net/docs/company/#api-companyGroup-get_qatalk
     */
    @GET("qatalk")
    Observable<GetQaTalkResponse> GetQaTalk();

    /**
     * title= 获取公开课信息
     * version = 1.1.0
     * api url= https://hbapidev.baobaobooks.net/docs/company/#api-companyGroup-get_lecture
     */
    @GET("lecture")
    Observable<GetLectureResponse> GetLecture();

}
