# Recipe for AESD Assignments
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Git repo for AESD assignments
SRC_URI = "git://github.com/brainhasan/Assignment-4.git;protocol=https;branch=master"

# Version info
PV = "1.0+git${SRCPV}"
SRCREV = "${AUTOREV}"

# Directory containing server sources
S = "${WORKDIR}/git/server"

# Linker flags
TARGET_LDFLAGS += "-pthread -lrt"

# Files to include in the final package
FILES:${PN} += "${bindir}/aesdsocket ${sysconfdir}/init.d/aesdsocket-start"

do_configure() {
    :
}

do_compile() {
    oe_runmake
}

do_install() {
    install -d ${D}${bindir}
    install -d ${D}${sysconfdir}/init.d

    # Install compiled binary
    install -m 0755 ${S}/aesdsocket ${D}${bindir}/aesdsocket

    # Install startup script
    install -m 0755 ${S}/aesdsocket-start-stop.sh ${D}${sysconfdir}/init.d/aesdsocket-start
}

# Ensure Yocto doesn’t try to strip or objcopy prebuilt binaries if needed
# (only necessary if the binary is already stripped)
INSANE_SKIP:${PN} += "already-stripped"
