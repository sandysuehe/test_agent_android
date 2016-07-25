package com.ifeng.at.testagent.driver.methodImpl;

import android.util.Log;

import com.ifeng.at.testagent.driver.MethodExecute;
import com.ifeng.at.testagent.rpc.Request;
import com.ifeng.at.testagent.rpc.Response;
import com.robotium.solo.Solo;

import java.util.Map;

/**
 * Created by lr on 2016/7/25.
 */
public class FinishActivity  implements MethodExecute{
    @Override
    public Response execute(Request request, Solo solo, Map varCache) {
        Response response = new Response();
        response.setId(request.getId());
        response.setVersion(request.getVersion());

        if (request.getArgs().length != 0){
            response.setResult(0);
            response.setError("Wrong number of args,need 0.");
            return  response;
        }

        if (solo != null){
            solo.finishOpenedActivities();
        }
        if (varCache != null){
            Log.d("finish", "clear varCache");
            varCache.clear();
        }

        response.setResult(1);
        return response;
    }

    @Override
    public String getMethodName() {
        return "finishActivity";
    }
}