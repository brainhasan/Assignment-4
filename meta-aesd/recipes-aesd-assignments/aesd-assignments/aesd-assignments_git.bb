LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/brainhasan/Assignment-4.git;protocol=https;branch=master"

PV = "1.0+git${SRCPV}"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git/server"

FILES:${PN} += "${bindir}/aesdsocket"
FILES:${PN} += "${bindir}/aesdsocket-start-stop.sh"

INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME:${PN}="aesdsocket-start-stop.sh"

TARGET_LDFLAGS = "-Wl,--hash-style=gnu -pthread -lrt"

do_configure() {
    :
}

do_compile() {
    oe_runmake CFLAGS="${CFLAGS}" LDFLAGS="${TARGET_LDFLAGS}"
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/aesdsocket ${D}${bindir}/
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${S}/aesdsocket-start-stop.sh ${D}${sysconfdir}/init.d/
}

