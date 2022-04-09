package com.kelvinappdev.app.ws.userservice;

import com.kelvinappdev.app.ws.ui.model.request.UserDetailsRequestModel;
import com.kelvinappdev.app.ws.ui.model.response.UserRest;

public interface UserService {
	UserRest createUser(UserDetailsRequestModel userDetails);
}
