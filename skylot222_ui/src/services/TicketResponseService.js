import http from "../http-common"; 

class TicketResponseService {
  getAllTicketResponses(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/ticketResponse/ticketResponses`, searchDTO);
  }

  get(ticketResponseId) {
    return this.getRequest(`/ticketResponse/${ticketResponseId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/ticketResponse?field=${matchData}`, null);
  }

  addTicketResponse(data) {
    return http.post("/ticketResponse/addTicketResponse", data);
  }

  update(data) {
  	return http.post("/ticketResponse/updateTicketResponse", data);
  }
  
  uploadImage(data,ticketResponseId) {
  	return http.postForm("/ticketResponse/uploadImage/"+ticketResponseId, data);
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

export default new TicketResponseService();
