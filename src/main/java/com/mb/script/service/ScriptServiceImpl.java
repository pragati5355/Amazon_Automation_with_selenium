package com.mb.script.service;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mb.common.exception.CustomException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class ScriptServiceImpl implements ScriptService {

    @Override
    public void run() {
        WebDriver driver = new ChromeDriver();
        try {
            
            driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fs%3Fk%3Dsony%2Btv%2B55%252B%2Binch%26crid%3D9320EWDZMG44%26sprefix%3Dsony%2Btv%2B55%252B%2Binch%252Caps%252C222%26ref%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
            driver.manage().window().maximize();

            Thread.sleep(3000);

            driver.findElement(By.id("ap_email")).sendKeys("pragatigawade55@gmail.com");
            driver.findElement(By.id("continue")).click();

            Thread.sleep(3000);

            driver.findElement(By.id("ap_password")).sendKeys("Pragati@55");
            driver.findElement(By.id("signInSubmit")).click();

            Thread.sleep(3000);

            driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("sony tv 55+ inch");
            driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).submit();

            Thread.sleep(3000);

            driver.findElement(By.linkText("Sony Bravia 139 cm (55 inches) 4K Ultra HD Smart LED Google TV KD-55X74L (Black)")).click();

            Thread.sleep(2000);

            driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();

            Thread.sleep(2000);

            driver.findElement(By.xpath("(//input[@aria-labelledby='attach-sidesheet-checkout-button-announce'])[1]")).click();

            Thread.sleep(3000);

        } catch (Exception e) {
            log.error("Thread interrupted", e);
           throw new CustomException("Script is executed",HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }
}
