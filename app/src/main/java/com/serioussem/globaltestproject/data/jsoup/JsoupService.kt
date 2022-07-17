package com.serioussem.globaltestproject.data.jsoup

import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import javax.inject.Inject

class JsoupService @Inject constructor() {
    private val baseUrl: String = "https://phgim.e-schools.info/"
    private val loginUrl: String = "${baseUrl}login_"
    private var userAgent: String =
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:102.0) Gecko/20100101 Firefox/102.0"
    private var login: String = "JuliaNabok"
    private var password: String = "qw1234"
    private var pupilId: String = "968758"
    private var quarterId: String = "27474"
    private var weekId: String = "2022-01-17"
    private var journalUrl: String =
        "${baseUrl}pupil/${pupilId}/dnevnik/quarter/${quarterId}/week/${weekId}"
    lateinit var siteHtml: String
    lateinit var securityTokenKey: String
    lateinit var securityTokenValue: String

    fun connectToSite(): String {
        try {
            val loginGet: Connection.Response = Jsoup
                .connect("https://phgim.e-schools.info/login_")
                .userAgent(userAgent)
                .timeout(5000)
                .method(Connection.Method.GET)
                .execute();
            val loginPage: Document = loginGet.parse()
            val securityToken: Elements = loginPage.select("input[name=csrfmiddlewaretoken]")
            securityTokenKey = securityToken.attr("name")
            securityTokenValue = securityToken.attr("value")



            val loginPost: Connection.Response = Jsoup
                .connect(loginUrl)
                .timeout(5000)
                .data(securityTokenKey, securityTokenValue)
                .data("password", password)
                .data("username", login)
                .cookies(loginGet.cookies())
                .userAgent(userAgent)
                .referrer(loginUrl)
                .method(Connection.Method.POST)
                .postDataCharset("windows-1251")
                .execute()

//            siteHtml = loginPost.cookies().toString()

            siteHtml = Jsoup
                .connect(journalUrl)
                .timeout(5000)
                .cookies(loginPost.cookies())
                .get()
                .toString()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return siteHtml
    }
}