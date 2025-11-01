LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit update-rc.d



SRC_URI = "git://github.com/brainhasan/Assignment-4.git;protocol=ssh;branch=master"

# Set the SRCREV to a specific commit hash
SRCREV = "afe4e227fdd033855c2cfc5a1611ca27c1be9bb9"
# Specify the directory where the source is located
S = "${WORKDIR}/git/server"

# Include aesdsocket binary and start-stop script
FILES:${PN} += "${bindir}/aesdsocket"
FILES:${PN} += "${bindir}/aesdsocket-start-stop.sh"

# Specify additional libraries or flags needed
TARGET_LDFLAGS += "-pthread -lrt"
INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME:${PN}="aesdsocket-start-stop.sh"


# No special configuration needed
do_configure () {
    :
}

# Compile the code using oe_runmake
do_compile () {
    oe_runmake
}

# Install binaries and scripts to their appropriate locations
do_install () {
    install -d ${D}${bindir}
    install -m 0755 ${S}/aesdsocket ${D}${bindir}/
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${S}/aesdsocket-start-stop.sh ${D}${sysconfdir}/init.d/
}

