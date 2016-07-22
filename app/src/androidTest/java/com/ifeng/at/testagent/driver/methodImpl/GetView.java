package com.ifeng.at.testagent.driver.methodImpl;

import android.view.View;

import com.ifeng.at.testagent.driver.MethodExecute;
import com.ifeng.at.testagent.rpc.Request;
import com.ifeng.at.testagent.rpc.Response;
import com.robotium.solo.Solo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lr on 2016/7/22.
 */
public class GetView implements MethodExecute{

    @Override
    public Response execute(Request request, Solo solo, Map varCache) {

        Response response = new Response();
        Map entity = new HashMap();

        response.setId(request.getId());
        response.setVersion(request.getVersion());
        if (request.getArgs().length != 1){
            response.setEntity(null);
            response.setResult(0);
            response.setError("Wrong number of params, need one.");
            return response;
        }

        View view = solo.getView(request.getArgs()[0]);
        entity.put("v", view);

        response.setError(null);
        response.setEntity(entity);
        response.setResult(1);

        return response;
    }

    @Override
    public String getMethodName() {
        return "getView";
    }
}
