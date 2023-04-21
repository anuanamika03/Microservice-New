package com.neom.assettech.serviceimpl;

import com.neom.assettech.model.NotificationModel;
import com.neom.assettech.repository.NotificationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NotificationServiceimplTest {

    @InjectMocks
    private NotificationServiceimpl notificationServiceimpl;

    @Mock
    private NotificationRepository notificationRepository;

    private NotificationModel notification;
    private List<NotificationModel> notificationsList;

    @Before
    public void setUp() {
        notification = new NotificationModel();
        notification.setNotificationID(1);
        notification.setAppID(1);
        notification.setAlertID(1);
        notification.setAction("Action1");
        notification.setWeatherparameter("Weatherparameter1");
        notification.setActionTimeStamp(new Date());
        notification.setAppName("AppName1");
        notification.setMessage("Message1");

        notificationsList = new ArrayList<>();
        notificationsList.add(notification);
    }

    @Test
    public void testFindAll_Positive() {
        when(notificationRepository.findAll()).thenReturn(notificationsList);
        List<NotificationModel> result = notificationServiceimpl.findAll();
        assertEquals(notificationsList, result);
    }

    @Test
    public void testFindAll_Negative() {
        when(notificationRepository.findAll()).thenReturn(new ArrayList<>());
        List<NotificationModel> result = notificationServiceimpl.findAll();
        assertEquals(new ArrayList<>(), result);
    }

    @Test
    public void testAddNotification_Positive() {
        when(notificationRepository.save(notification)).thenReturn(notification);
        notificationServiceimpl.addnotification(notification);
    }


    @Test
    public void testGetNotifications_Positive() {
        when(notificationRepository.getNotifications()).thenReturn(notificationsList);
        List<NotificationModel> result = notificationServiceimpl.getNotifications();
        assertEquals(notificationsList, result);
    }

    @Test
    public void testGetNotifications_Negative() {
        when(notificationRepository.getNotifications()).thenReturn(new ArrayList<>());
        List<NotificationModel> result = notificationServiceimpl.getNotifications();
        assertEquals(new ArrayList<>(), result);
    }
}

