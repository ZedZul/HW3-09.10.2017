package com.zedzul.github.hw3_09102017.json;

import com.zedzul.github.hw3_09102017.BuildConfig;
import com.zedzul.github.hw3_09102017.IUser;
import com.zedzul.github.hw3_09102017.IUserParser;
import com.zedzul.github.hw3_09102017.http.IHttpClient;
import com.zedzul.github.hw3_09102017.mocks.MockHttpClient;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static com.zedzul.github.hw3_09102017.SomeUtils.inputStreamToString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 24)
public class JsonTests {

    private static final String DATE = "Tue, 10 Oct 2017 18:57:55";
    private static final String DOB_J_HOUSE = "Thu, 11 Jun 1959 11:00:00";
    private IHttpClient mHttpClient;

    @Before
    public void initiate() {

        mHttpClient = mock(IHttpClient.class);
    }

    @Test
    public void testJsonObjectParse() throws Exception {

        final InputStream mockInputStream = MockHttpClient.mockRequest("src\\test\\resources\\user.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockInputStream);
        final InputStream response = mHttpClient.request("http://take.user.com/api");

        final IUserParser pUserParserJson = new UserParserJsonObject(inputStreamToString(response));
        final IUser pUser = pUserParserJson.parse();

        Assert.assertEquals(pUser.getId(), 1);
        Assert.assertEquals(pUser.getName(), "Ivan Ivanov");
        Assert.assertEquals(new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss", Locale.ENGLISH).format(pUser.getDateOfBirth()), DATE);
        Assert.assertEquals(pUser.getAvatarUrl(), "random.link/avatar.png");

    }

    @Test
    public void testJsonArrayParse() throws Exception {
        final InputStream mockInputStream = MockHttpClient.mockRequest("src\\test\\resources\\user_list.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockInputStream);
        final InputStream response = mHttpClient.request("http://take.user.com/api");

        final IUsersListParser pUsersListParserJsonArray = new UsersListParserJsonArray(inputStreamToString(response));

        final IUsersList pUserList = pUsersListParserJsonArray.parse();

        final IUser pUser = pUserList.getUsersList().get(1);

        Assert.assertEquals(pUser.getId(), 2);
        Assert.assertEquals(pUser.getName(), "Jorge House");
        Assert.assertEquals(new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss", Locale.ENGLISH).format(pUser.getDateOfBirth()), DOB_J_HOUSE);
        Assert.assertEquals(pUser.getAvatarUrl(), "random.link/avatar.png");
    }
}