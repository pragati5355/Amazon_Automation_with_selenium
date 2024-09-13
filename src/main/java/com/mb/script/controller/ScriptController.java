package com.mb.script.controller;

import java.io.IOException;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.common.constant.ApiPath;
import com.mb.common.model.SuccessResponse;
import com.mb.common.util.CustomResponseBuilder;
import com.mb.script.constants.ScriptApiPath;
import com.mb.script.constants.ScriptSuccessMessage;
import com.mb.script.service.ScriptService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiPath.BASE_URL)
public class ScriptController {

    private final Environment environment;

    private final CustomResponseBuilder customResponseBuilder;

    private final ScriptService scriptService;;


    @GetMapping(ScriptApiPath.SCRIPT_BASE_URL)
    public ResponseEntity<SuccessResponse<String>> runScript() throws IOException {
       
       scriptService.run();
        return customResponseBuilder.buildSuccessResponse(
                environment.getProperty(ScriptSuccessMessage.SUCESS),
                null,
                HttpStatus.OK);
    }
}
