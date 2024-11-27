import http from "../http-common"; 

class UserRoleService {
  getAllUserRoles(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/userRole/userRoles`, searchDTO);
  }

  get(userRoleId) {
    return this.getRequest(`/userRole/${userRoleId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/userRole?field=${matchData}`, null);
  }

  addUserRole(data) {
    return http.post("/userRole/addUserRole", data);
  }

  update(data) {
  	return http.post("/userRole/updateUserRole", data);
  }
  
  uploadImage(data,userRoleId) {
  	return http.postForm("/userRole/uploadImage/"+userRoleId, data);
  }




	postRequest(url, data) {
		return http.post(url, data);
      };

	getRequest(url, params) {
        return http.get(url, {
        	params: params
        });
    };

}

export default new UserRoleService();
