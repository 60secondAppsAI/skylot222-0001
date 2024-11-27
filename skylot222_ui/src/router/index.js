import Vue from "vue";
import VueRouter from "vue-router";
import DefaultLayout from "@/layouts/DefaultLayout.vue";
import Users from  '@/pages/Users.vue';
import UserDetail from  '@/pages/UserDetail.vue';
import Roles from  '@/pages/Roles.vue';
import RoleDetail from  '@/pages/RoleDetail.vue';
import UserRoles from  '@/pages/UserRoles.vue';
import UserRoleDetail from  '@/pages/UserRoleDetail.vue';
import Categorys from  '@/pages/Categorys.vue';
import CategoryDetail from  '@/pages/CategoryDetail.vue';
import Listings from  '@/pages/Listings.vue';
import ListingDetail from  '@/pages/ListingDetail.vue';
import Bids from  '@/pages/Bids.vue';
import BidDetail from  '@/pages/BidDetail.vue';
import Payments from  '@/pages/Payments.vue';
import PaymentDetail from  '@/pages/PaymentDetail.vue';
import Messages from  '@/pages/Messages.vue';
import MessageDetail from  '@/pages/MessageDetail.vue';
import Feedbacks from  '@/pages/Feedbacks.vue';
import FeedbackDetail from  '@/pages/FeedbackDetail.vue';
import Watchlists from  '@/pages/Watchlists.vue';
import WatchlistDetail from  '@/pages/WatchlistDetail.vue';
import Transactions from  '@/pages/Transactions.vue';
import TransactionDetail from  '@/pages/TransactionDetail.vue';
import Notifications from  '@/pages/Notifications.vue';
import NotificationDetail from  '@/pages/NotificationDetail.vue';
import SupportTickets from  '@/pages/SupportTickets.vue';
import SupportTicketDetail from  '@/pages/SupportTicketDetail.vue';
import TicketResponses from  '@/pages/TicketResponses.vue';
import TicketResponseDetail from  '@/pages/TicketResponseDetail.vue';
import Addresss from  '@/pages/Addresss.vue';
import AddressDetail from  '@/pages/AddressDetail.vue';
import Shipments from  '@/pages/Shipments.vue';
import ShipmentDetail from  '@/pages/ShipmentDetail.vue';
import Wishlists from  '@/pages/Wishlists.vue';
import WishlistDetail from  '@/pages/WishlistDetail.vue';
import Reviews from  '@/pages/Reviews.vue';
import ReviewDetail from  '@/pages/ReviewDetail.vue';
import Promotions from  '@/pages/Promotions.vue';
import PromotionDetail from  '@/pages/PromotionDetail.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: () => import("../views/HomeView.vue"),
			redirect: '/users',
																			  },
  {
    path: "/pricing",
    name: "PricingView",
    component: () => import("../views/PricingView.vue"),
  },
  {
    path: "/arts-gallery",
    name: "ArtsGalleryView",
    component: () => import("../views/ArtsGalleryView.vue"),
  },
  {
    path: "/checkout/:id",
    name: "CheckoutView",
    component: () => import("../views/CheckoutView.vue"),
  },
  {
    path: "/stripe-checkout",
    name: "StripeCheckoutView",
    component: () => import("../views/StripeCheckoutView.vue"),
  },
	{
		path: '/users',
		name: 'Users',
		layout: DefaultLayout,
		component: Users,
	},
	{
	    path: '/user/:userId', 
	    name: 'UserDetail',
		layout: DefaultLayout,
	    component: UserDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/roles',
		name: 'Roles',
		layout: DefaultLayout,
		component: Roles,
	},
	{
	    path: '/role/:roleId', 
	    name: 'RoleDetail',
		layout: DefaultLayout,
	    component: RoleDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/userRoles',
		name: 'UserRoles',
		layout: DefaultLayout,
		component: UserRoles,
	},
	{
	    path: '/userRole/:userRoleId', 
	    name: 'UserRoleDetail',
		layout: DefaultLayout,
	    component: UserRoleDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/categorys',
		name: 'Categorys',
		layout: DefaultLayout,
		component: Categorys,
	},
	{
	    path: '/category/:categoryId', 
	    name: 'CategoryDetail',
		layout: DefaultLayout,
	    component: CategoryDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/listings',
		name: 'Listings',
		layout: DefaultLayout,
		component: Listings,
	},
	{
	    path: '/listing/:listingId', 
	    name: 'ListingDetail',
		layout: DefaultLayout,
	    component: ListingDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/bids',
		name: 'Bids',
		layout: DefaultLayout,
		component: Bids,
	},
	{
	    path: '/bid/:bidId', 
	    name: 'BidDetail',
		layout: DefaultLayout,
	    component: BidDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/payments',
		name: 'Payments',
		layout: DefaultLayout,
		component: Payments,
	},
	{
	    path: '/payment/:paymentId', 
	    name: 'PaymentDetail',
		layout: DefaultLayout,
	    component: PaymentDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/messages',
		name: 'Messages',
		layout: DefaultLayout,
		component: Messages,
	},
	{
	    path: '/message/:messageId', 
	    name: 'MessageDetail',
		layout: DefaultLayout,
	    component: MessageDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/feedbacks',
		name: 'Feedbacks',
		layout: DefaultLayout,
		component: Feedbacks,
	},
	{
	    path: '/feedback/:feedbackId', 
	    name: 'FeedbackDetail',
		layout: DefaultLayout,
	    component: FeedbackDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/watchlists',
		name: 'Watchlists',
		layout: DefaultLayout,
		component: Watchlists,
	},
	{
	    path: '/watchlist/:watchlistId', 
	    name: 'WatchlistDetail',
		layout: DefaultLayout,
	    component: WatchlistDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/transactions',
		name: 'Transactions',
		layout: DefaultLayout,
		component: Transactions,
	},
	{
	    path: '/transaction/:transactionId', 
	    name: 'TransactionDetail',
		layout: DefaultLayout,
	    component: TransactionDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/notifications',
		name: 'Notifications',
		layout: DefaultLayout,
		component: Notifications,
	},
	{
	    path: '/notification/:notificationId', 
	    name: 'NotificationDetail',
		layout: DefaultLayout,
	    component: NotificationDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/supportTickets',
		name: 'SupportTickets',
		layout: DefaultLayout,
		component: SupportTickets,
	},
	{
	    path: '/supportTicket/:supportTicketId', 
	    name: 'SupportTicketDetail',
		layout: DefaultLayout,
	    component: SupportTicketDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/ticketResponses',
		name: 'TicketResponses',
		layout: DefaultLayout,
		component: TicketResponses,
	},
	{
	    path: '/ticketResponse/:ticketResponseId', 
	    name: 'TicketResponseDetail',
		layout: DefaultLayout,
	    component: TicketResponseDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/addresss',
		name: 'Addresss',
		layout: DefaultLayout,
		component: Addresss,
	},
	{
	    path: '/address/:addressId', 
	    name: 'AddressDetail',
		layout: DefaultLayout,
	    component: AddressDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/shipments',
		name: 'Shipments',
		layout: DefaultLayout,
		component: Shipments,
	},
	{
	    path: '/shipment/:shipmentId', 
	    name: 'ShipmentDetail',
		layout: DefaultLayout,
	    component: ShipmentDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/wishlists',
		name: 'Wishlists',
		layout: DefaultLayout,
		component: Wishlists,
	},
	{
	    path: '/wishlist/:wishlistId', 
	    name: 'WishlistDetail',
		layout: DefaultLayout,
	    component: WishlistDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/reviews',
		name: 'Reviews',
		layout: DefaultLayout,
		component: Reviews,
	},
	{
	    path: '/review/:reviewId', 
	    name: 'ReviewDetail',
		layout: DefaultLayout,
	    component: ReviewDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/promotions',
		name: 'Promotions',
		layout: DefaultLayout,
		component: Promotions,
	},
	{
	    path: '/promotion/:promotionId', 
	    name: 'PromotionDetail',
		layout: DefaultLayout,
	    component: PromotionDetail,
	    props: true // Pass route params as props to the component
  	},
];

const router = new VueRouter({
  mode: "hash",
  base: process.env.BASE_URL,
  routes,
});

export default router;
