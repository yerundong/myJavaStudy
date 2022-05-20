export const jsonToFormData = (obj, deepStringify = false) => {
    const formData = new FormData()
    Object.keys(obj).forEach(k => {
        ![undefined, null].includes(obj[k]) &&
        formData.append(
            k,
            deepStringify && typeof obj[k] === 'object'
                ? JSON.stringify(obj[k])
                : obj[k]
        )
    })
    return formData
}