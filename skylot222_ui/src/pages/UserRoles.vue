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
            <userRole-table
            v-if="userRoles && userRoles.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:userRoles="userRoles"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-user-roles="getAllUserRoles"
             >

            </userRole-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import UserRoleTable from "@/components/UserRoleTable";
import UserRoleService from "../services/UserRoleService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    UserRoleTable,
  },
  data() {
    return {
      userRoles: [],
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
    async getAllUserRoles(sortBy='userRoleId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await UserRoleService.getAllUserRoles(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.userRoles.length) {
					this.userRoles = response.data.userRoles;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching userRoles:", error);
        }
        
      } catch (error) {
        console.error("Error fetching userRole details:", error);
      }
    },
  },
  mounted() {
    this.getAllUserRoles();
  },
  created() {
    this.$root.$on('searchQueryForUserRolesChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllUserRoles();
    })
  }
};
</script>
<style></style>
