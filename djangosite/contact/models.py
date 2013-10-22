from django.db import models


class Contact(models.Model):
    GENDER_CHOICES = (
        (1, 'Male'),
        (2, 'Female'),
    )
    subject = models.CharField(max_length=100, blank=True)
    message = models.TextField(blank=True)
    sender = models.EmailField(max_length=100)
    gender = models.IntegerField(choices=GENDER_CHOICES)
    cc = models.BooleanField()
