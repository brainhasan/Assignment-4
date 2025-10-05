
##############################################################
#
# AESD-ASSIGNMENTSh
#
##############################################################

#TODO: Fill up the contents below in order to reference your assignment 3 git contents
AESD_ASSIGNMENTS_VERSION ='7039e5542b5b26d34ba6e5da82647e479af588c3'
# Note: Be sure to reference the *ssh* repository URL here (not https) to work properly
# with ssh keys and the automated build/test system.
# Your site should start with git@github.com:
AESD_ASSIGNMENTS_SITE = 'git@github.com:brainhasan/Assignment-4.git'
AESD_ASSIGNMENTS_SITE_METHOD = git
AESD_ASSIGNMENTS_GIT_SUBMODULES = YES

define AESD_ASSIGNMENTS_BUILD_CMDS
	@echo "=== BUILDING AESD_ASSIGNMENTS ==="
	@echo "Build directory: $(@D)"
	@ls -la $(@D)/ || echo "Build directory not found"
	@ls -la $(@D)/finder-app/ || echo "finder-app directory not found"
	
	$(MAKE) $(TARGET_CONFIGURE_OPTS) -C $(@D)/finder-app all
	
	@echo "=== BUILD COMPLETE ==="
endef

# TODO add your writer, finder and finder-test utilities/scripts to the installation steps below
define AESD_ASSIGNMENTS_INSTALL_TARGET_CMDS
        $(INSTALL) -d -m 0755 $(TARGET_DIR)/usr/bin/conf
	$(INSTALL) -d 0755 $(@D)/conf/ $(TARGET_DIR)/etc/finder-app/conf/
	$(INSTALL) -m 0755 $(@D)/conf/* $(TARGET_DIR)/etc/finder-app/conf/
	$(INSTALL) -m 0755 $(@D)/assignment-autotest/test/assignment4/* $(TARGET_DIR)/bin
	$(INSTALL) -m 0755 $(@D)/finder-app/writer $(TARGET_DIR)/usr/bin
	$(INSTALL) -m 0755 $(@D)/finder-app/finder.sh $(TARGET_DIR)/usr/bin
	$(INSTALL) -m 0755 $(@D)/finder-app/finder-test.sh $(TARGET_DIR)/usr/bin
	$(INSTALL) -d 0755 $(@D)/conf/ $(TARGET_DIR)/usr/bin
	$(INSTALL) -m 0755 $(@D)/conf/* $(TARGET_DIR)/usr/bin/conf
	$(INSTALL) -m 0755 $(@D)/finder-app/dependencies.sh $(TARGET_DIR)/usr/bin
endef

$(eval $(generic-package))
