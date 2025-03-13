FROM php:8.2-apache

# Copy the PHP application
COPY index.php /var/www/html/
COPY flag.txt /
RUN chmod 644 /flag.txt

# Set proper permissions
RUN chown -R www-data:www-data /var/www/html \
    && chmod -R 755 /var/www/html

# Enable Apache rewrite module
RUN a2enmod rewrite

# Configure PHP and Apache
RUN echo "ServerName localhost" >> /etc/apache2/apache2.conf 