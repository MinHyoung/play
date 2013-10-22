from django.conf.urls import patterns, url
from contact import views

urlpatterns = patterns('',
    url(r'^contact/$', views.contact, name='contact'), 
    url(r'^pure/$', views.pure_contact, name='pure_contact'), 
    url(r'^thanks/$', views.thanks, name='thanks'),     
)