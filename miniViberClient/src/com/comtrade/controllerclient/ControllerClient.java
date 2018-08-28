package com.comtrade.controllerclient;

import java.util.List;
import java.util.Map;

import com.comtrade.constant.Constant;
import com.comtrade.domain.Friends;
import com.comtrade.domain.GroupMessages;
import com.comtrade.domain.Groups;
import com.comtrade.domain.PrivateMessage;
import com.comtrade.domain.SendingFile;
import com.comtrade.transfer.TransferClass;
import com.comtrade.view.admin.AdminForm;
import com.comtrade.view.user.UserForm;

public class ControllerClient {
	private static ControllerClient instance;
	private UserForm uf;
	private AdminForm adminForm;
	private ControllerClient() {

	}

	public static ControllerClient getInstance() {
		if (instance == null) {
			instance = new ControllerClient();
		}
		return instance;
	}

	public void setUserForm(UserForm userForm) {
		uf = userForm;
	}

	public void setAdminForm(AdminForm adminForm) {
		this.adminForm = adminForm;
	}

	@SuppressWarnings("unchecked")
	public void processServerRequirements(TransferClass tc) {
		switch (tc.getOperation()) {
		case Constant.CREATE_USER:
			break;
		case Constant.REFRESH_FORM:
			if (uf != null) {
				Map<String, Object> hm = (Map<String, Object>) tc.getServerObject();
				uf.refreshForm(hm);
			}
			if (adminForm != null) {
				Map<String, Object> hm = (Map<String, Object>) tc.getServerObject();
				adminForm.refreshUsers(hm);
			}
			break;
		case Constant.UPDATE_SUCCESSFULL:
			Map<String, Object> hm1 = (Map<String, Object>) tc.getServerObject();
			uf.updateClientPersonalData(hm1);
			break;
		case Constant.FRIEND_REQUEST_SENT:
			Friends newFr = (Friends) tc.getServerObject();
			uf.refreshFriendRelations(newFr);
			break;
		case Constant.FRIEND_REQUEST_ACCEPTED:
			Friends newFr1 = (Friends) tc.getServerObject();
			uf.refreshFriendRelations(newFr1);
			break;
		case Constant.FRIEND_REQUEST_DECLINED:
			Friends newFr2 = (Friends) tc.getServerObject();
			uf.refreshFriendRelations(newFr2);
			break;
		case Constant.FRIEND_REQUEST_BLOCK_FRIEND:
			Friends newFr3 = (Friends) tc.getServerObject();
			uf.refreshFriendRelations(newFr3);
			break;
		case Constant.FRIEND_REQUEST_BLOCK_NON_FRIEND:
			Friends newFr4 = (Friends) tc.getServerObject();
			uf.refreshFriendRelations(newFr4);
			break;
		case Constant.MESSAGE_PENDING_OPERATION:
			PrivateMessage pm = (PrivateMessage) tc.getServerObject();
			uf.refreshMsgForm(pm);
			break;
		case Constant.MESSAGE_DELIVERED_OPERATION:
			PrivateMessage pm1 = (PrivateMessage) tc.getServerObject();
			uf.refreshMsgStatus(pm1);
			break;
		case Constant.MESSAGE_SEEN_OPERATION:
			PrivateMessage pm2 = (PrivateMessage) tc.getServerObject();
			uf.refreshMsgStatus(pm2);
			break;
		case Constant.GROUP_CREATE_FAILED:
			uf.groupCreateInfo(tc);
			break;
		case Constant.GROUP_CREATE_SUCCESS:
			if (uf != null) {
				uf.groupCreateInfo(tc);
				uf.refreshGroupsGroupCreated(tc.getServerObject());
			}
			if (adminForm != null) {
				Groups newGroup = (Groups) tc.getServerObject();
				adminForm.groupCreatedRefreshGroups(newGroup);
			}
			break;
		case Constant.GROUPMEMBERS_CREATED:
			if (uf != null) {
				uf.refreshGroupMembers(tc);
			}
			if (adminForm != null) {
				adminForm.refreshGroupMembers(tc);
			}
			break;
			
		case Constant.GROUPMEMBERS_KICKED:
			if (uf != null) {
				uf.refreshGroupMembers(tc);
			}
			if (adminForm != null) {
				adminForm.refreshGroupMembers(tc);
			}
			break;
		case Constant.GROUPMEMBERS_ASKTOJOIN:
			if (uf != null) {
				uf.refreshGroupMembers(tc);
			}
			if (adminForm != null) {
				adminForm.refreshGroupMembers(tc);
			}
			break;
		case Constant.GROUPMEMBERS_CANCELREQUEST:
			if (uf != null) {
				uf.refreshGroupMembers(tc);
			}
			if (adminForm != null) {
				adminForm.refreshGroupMembers(tc);
			}
			break;
		case Constant.GROUPMEMBERS_ACCEPTEDMEMBERSHIP:
			if (uf != null) {
				uf.refreshGroupMembers(tc);
			}
			if (adminForm != null) {
				adminForm.refreshGroupMembers(tc);
			}
			break;
		case Constant.GROUPMEMBERS_DECLINEDMEMBERSHIP:
			if (uf != null) {
				uf.refreshGroupMembers(tc);
			}
			if (adminForm != null) {
				adminForm.refreshGroupMembers(tc);
			}
			break;
		case Constant.GROUPMESSAGE_NEWMESSAGE:
			uf.addGroupMessageToChat((GroupMessages) tc.getServerObject());
			break;
		case Constant.LIST_OF_ACTIVE_USERS_CHANGED:
			List<Integer> listOfActiveUsers = (List<Integer>) tc.getServerObject();
			if (adminForm != null) {
				adminForm.changeListOfActiveUsers(listOfActiveUsers);
			}
			if (uf != null) {
				uf.changeListOfActiveUsers(listOfActiveUsers);
			}
			break;
		case Constant.UPDATED_PROFILE_PICTURE:
			SendingFile sf = (SendingFile) tc.getServerObject();
			if (uf != null) {
				uf.addUserProfilPicture(sf);
			}
			if (adminForm != null) {
				adminForm.dodajSliku(sf);
			}
			break;
		
		case Constant.UPDATED_GROUP_PICTURE:
			SendingFile sfRecievedGroupPicture = (SendingFile) tc.getServerObject();
			if (uf!=null) {
				uf.addGroupPicture(sfRecievedGroupPicture);
			}
			if (adminForm!=null) {
				adminForm.addGroupPicture(sfRecievedGroupPicture);
			}
			break;
		default:
			break;
		}

	}

}
