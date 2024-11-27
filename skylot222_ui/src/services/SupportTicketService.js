import http from "../http-common"; 

class SupportTicketService {
  getAllSupportTickets(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/supportTicket/supportTickets`, searchDTO);
  }

  get(supportTicketId) {
    return this.getRequest(`/supportTicket/${supportTicketId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/supportTicket?field=${matchData}`, null);
  }

  addSupportTicket(data) {
    return http.post("/supportTicket/addSupportTicket", data);
  }

  update(data) {
  	return http.post("/supportTicket/updateSupportTicket", data);
  }
  
  uploadImage(data,supportTicketId) {
  	return http.postForm("/supportTicket/uploadImage/"+supportTicketId, data);
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

export default new SupportTicketService();
