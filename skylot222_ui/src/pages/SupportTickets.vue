<template>
  <div class="content">
    <div class="row">
      <div class="col-12">
        <card class="card-plain">
          <!-- <template slot="header">
            <h4 class="card-title">Table on Plain Background</h4>
            <p class="category">Here is a subtitle for this table</p>
          </template>-->
          <div class="table-full-width text-left">
            <supportTicket-table
            v-if="supportTickets && supportTickets.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:supportTickets="supportTickets"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-support-tickets="getAllSupportTickets"
             >

            </supportTicket-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import SupportTicketTable from "@/components/SupportTicketTable";
import SupportTicketService from "../services/SupportTicketService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    SupportTicketTable,
  },
  data() {
    return {
      supportTickets: [],
	  totalElements: 0,
      page: 0,
      searchQuery: '',     
      table1: {
        title: "Simple Table",
        columns: [...tableColumns],
        data: [...tableData],
      },
    };
  },
  methods: {
    async getAllSupportTickets(sortBy='supportTicketId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await SupportTicketService.getAllSupportTickets(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.supportTickets.length) {
					this.supportTickets = response.data.supportTickets;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching supportTickets:", error);
        }
        
      } catch (error) {
        console.error("Error fetching supportTicket details:", error);
      }
    },
  },
  mounted() {
    this.getAllSupportTickets();
  },
  created() {
    this.$root.$on('searchQueryForSupportTicketsChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllSupportTickets();
    })
  }
};
</script>
<style></style>
